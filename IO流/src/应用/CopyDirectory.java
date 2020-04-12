package 应用;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//多线程复制文件夹中的所有内容
public class CopyDirectory {
    private static class CopyFileTask implements Runnable {
        private final String srcPath;
        private final String destPath;

        CopyFileTask(String srcPath, String destPath) {
            this.srcPath = srcPath;
            this.destPath = destPath;
        }

        @Override
        public void run() {
            try {
                copyFile(srcPath, destPath);
                System.out.println(destPath + " 文件复制成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String srcAbsPath;
    private static String desAbsPath;
    private static ExecutorService threadPool;

    public static void main(String[] args) throws IOException {

        threadPool = Executors.newFixedThreadPool(50);
        String srcPath = "E:\\code\\javapractice\\IO流";
        String destPath = "E:\\目标文件";

        //创建文件对象
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

        //获取文件的绝对路径
        srcAbsPath = srcFile.getAbsolutePath();
        desAbsPath = destFile.getAbsolutePath();

        // TODO: 检查源文件是否存在，是否是目录
        // TODO: 检查目标文件是否不存在
        // TODO: 检查目标文件的上一级目录是否存在

        //复制文件夹
        copyDirectory(srcPath);

        threadPool.shutdown();
    }

    /**
     * 遍历所有的目录结构
     * 如果是目录，我也随着创建目录
     * 如果是文件，调用复制文件的方式进行复制
     * @param srcPath   源目录路径
     * @throws IOException
     */
    private static void copyDirectory(String srcPath) throws IOException {
        File srcRoot = new File(srcPath);
        travelDirectory(srcRoot);
    }

    private static void doDirectory(File directory) {
        // 为了找出要复制的目录的相对路径
        String srcPath = directory.getAbsolutePath();//获取文件夹的绝对路径
        String relativePath = srcPath.substring(srcAbsPath.length());//从源文件夹的绝对路径分割
        String destPath = desAbsPath + relativePath;//拼接路径

        File destDirectory = new File(destPath);
        //创建文件夹
        destDirectory.mkdir();  // 因为树从根往下遍历的，所以，上一级的目录，一定以及被创建了
        System.out.println(destPath + " 目录创建成功");
    }

    private static void doFile(File file) throws IOException {
        String srcPath = file.getAbsolutePath();
        String relativePath = srcPath.substring(srcAbsPath.length());
        String destPath = desAbsPath + relativePath;

        /*
        //复制文件内容
        copyFile(srcPath, destPath);
        System.out.println(destPath + " 文件复制成功");
        */

        threadPool.execute(new CopyFileTask(srcPath, destPath));
    }

    private static void copyFile(String srcPath, String destPath) throws IOException {
        try (InputStream is = new FileInputStream(srcPath)) {
            try (OutputStream os = new FileOutputStream(destPath)) {
                byte[] buffer = new byte[4096];
                int len;

                while ((len = is.read(buffer)) != -1) {
                    os.write(buffer, 0, len);
                }

                os.flush();
            }
        }
    }

    private static void doNode(File node) throws IOException {
        if (node.isDirectory()) {
            doDirectory(node);
        } else {
            doFile(node);
        }
    }

    //深度遍历文件夹
    private static void travelDirectory(File root) throws IOException {
        doNode(root);   // 被遍历的每个结点，都需要被调用

        if (root.isDirectory()) {
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    travelDirectory(file);
                }
            }
        }
    }
}
