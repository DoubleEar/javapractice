package 文件文件夹;

import java.io.File;
import java.util.Scanner;
//创建文件夹
public class MakeDirectory {
    public static void main(String[] args) {
        File file=new File("耳耳");
        Scanner sc=new Scanner(System.in);
        System.out.println("文件对象创建成功");
        sc.nextLine();
        file.mkdir();
        System.out.println("文件夹创建成功");
        sc.nextLine();
        //file.delete();
        //System.out.println("文件夹删除成功");

        File f=new File("耳耳/李静静");
        sc.nextLine();
        f.mkdir();
        System.out.println("文件夹创建成功");
        sc.nextLine();
        //f.delete();   //只能删除空的文件夹
    }
}
