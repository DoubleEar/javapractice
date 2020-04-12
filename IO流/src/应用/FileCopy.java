package 应用;

import java.io.*;
//文件复制
public class FileCopy {
    public static void main(String[] args) throws IOException {
        String srcPath="java运算符优先级.jpg";
        String destPath="MyDest.jpg";

        //1.判断源文件
        File file=new File(srcPath);
        if(!file.exists()){
            System.out.println("原文件不存在"+srcPath);
            return;
        }

        if(file.isDirectory()){
            System.out.println("原文件是文件夹"+srcPath);
            return;
        }

        //2.判断目标文件
        File destFile=new File(destPath);
        if(destFile.exists()){
            System.out.println("目标文件已经存在"+srcPath);
            return;
        }

        //复制-以二进制形式进行复制
        // 一次读 4K 数据，把 4K 数据写入到目标文件中

        try(InputStream is=new FileInputStream(srcPath)) {
            try(OutputStream os=new FileOutputStream(destFile)){
                byte[] buffer=new byte[4096];

                int len;
                while ((len=is.read(buffer,0,4096))!=-1){
                    os.write(buffer,0,len);
                }
                os.flush();//冲刷
            }
        }
    }
}
