package 文件文件夹;

import java.io.File;
import java.util.Scanner;
//删除文件
public class DeleteFile {
    public static void main(String[] args) {
        File file=new File("耳耳");
        System.out.println("文件对象创建成功");
        Scanner sc=new Scanner(System.in);
        sc.nextLine();

        //file.delete();    //立即删除
        //System.out.println("文件删除成功");

        System.out.println("调用file.deleteOnExit()");
        file.deleteOnExit();    //JVM退出后才删除
        sc.nextLine();
        System.out.println("文件删除成功");
    }
}
