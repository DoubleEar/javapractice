package 文件文件夹;

import java.io.File;
//列出文件夹下所有文件
public class ListFiles {
    public static void main(String[] args) {
        File file=new File(".");
        File[] files = file.listFiles();
        if(file==null){
            System.out.println("对不是文件夹调用 listFiles()");
            return;
        }

        if(files.length==0){
            System.out.println("空文件夹");
        }

        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
    }
}
