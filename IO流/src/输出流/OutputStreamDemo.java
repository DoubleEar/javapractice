package 输出流;

import java.io.*;
//写入文件
public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {
        try(OutputStream os=new FileOutputStream("加油中国.txt")){
            /*
            os.write('H');
            os.write('e');
            os.write('l');
            os.write('l');
            os.write('o');
            os.write(0x0D);//\r
            os.write(0x0A);//\n

            os.flush();
            */

            /*
            byte[] buffer={'H','e','l','l','o',0X0D,0X0A};
            os.write(buffer,0,buffer.length);
            os.flush();
            */

            /*
            String s="你好，中国!";
            // 只能把 String 的字符串 转化为(编码为) byte[]，指定字符集编码
            byte[] buffer=s.getBytes("GBK");
            os.write(buffer,0,buffer.length);
            os.flush();
            */

            /*
            try(Writer writer=new OutputStreamWriter(os,"UTF-8")){
                writer.append("你好，中国");
                os.flush();
            }
            */

            try(PrintWriter printWriter=new PrintWriter(new OutputStreamWriter(os,"UTF-8"))){
                    for(int i=0;i<10;i++){
                        printWriter.printf("%02d:你好世界%n",i);
                    }
                    printWriter.flush();
            }
        }
    }
}
