package 文件文件夹;

import java.io.File;
//剪切粘贴文件
public class CutAndPasteFile {
    public static void main(String[] args) {
        //创建原始文件对象
        File file = new File("你好.txt");
        //创建要复制到的文件对象
        File dest = new File("out/你好.txt");
        file.renameTo(dest);
    }
}
