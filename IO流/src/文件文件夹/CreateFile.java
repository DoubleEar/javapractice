package 文件文件夹;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
//创建文件
public class CreateFile {
    public static void main(String[] args) throws IOException {
        File file=new File("耳耳");
        Scanner sc=new Scanner(System.in);
        System.out.println("文件对象创建成功");
        sc.nextLine();
        file.createNewFile();
        System.out.println("文件创建成功");
    }
}
