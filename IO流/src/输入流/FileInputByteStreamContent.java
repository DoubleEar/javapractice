package 输入流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputByteStreamContent {
    public static void main(String[] args) throws IOException{
        /*
        //读取没有中文的内容
        try(InputStream is = new FileInputStream("没有中文的文件.txt")){
            byte[] buffer=new byte[1024];
            int len=is.read(buffer);
            System.out.println(len);
            System.out.println("========================================");
            StringBuilder sb=new StringBuilder();

            for(int i=0;i<len;i++){
                sb.append((char)buffer[i]);
            }

            String s = sb.toString();
            System.out.println(s);
        }
        */

        //读取有中文的内容
        try(InputStream is = new FileInputStream("有中文的文件.txt")){
            byte[] buffer=new byte[1024];
            int len=is.read(buffer);
            System.out.println(len);
            System.out.println("========================================");

            String s = new String(buffer, 0, len, "UTF-8");
            System.out.println(s);
        }
    }
}
