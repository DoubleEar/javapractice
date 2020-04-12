package 文件文件夹;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
//遍历文件夹
public class TraversalFile {
    //深度优先遍历文件夹
    public static void depthFirstTraversal(File root){
        System.out.println(root.getAbsolutePath());

        // root 不是文件夹 OR root 空文件夹 -> 叶子
        if(root.isFile())
            return;

        File[] files = root.listFiles();

        if(files==null)
            return;
        if(files.length==0)
            return;

        for(File file:files)
            depthFirstTraversal(file);
    }

    //广度优先遍历文件夹
    public static void  breadthFirstTraversal(File root){
        Queue<File> queue=new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            File curFile=queue.poll();
            System.out.println(curFile.getAbsolutePath());
            if(curFile.isDirectory()){
                File[] files = curFile.listFiles();
                if(files!=null){
                    for(File file:files){
                        queue.offer(file);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String path="E:\\code\\javapractice\\IO流";
        File file=new File(path);

        depthFirstTraversal(file);
        System.out.println("==============================================");
        breadthFirstTraversal(file);
    }
}
