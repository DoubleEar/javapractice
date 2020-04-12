package 应用.文件加密解密;

import java.io.*;

public class Decrypt {
    public static void main(String[] args) throws IOException {
        String secretKey="机密文件";

        String srcPath="加密后的文件.txt";
        String destPath="解密后的文件.txt";

        try(InputStream is=new FileInputStream(srcPath)){
            try (OutputStream os=new FileOutputStream(destPath)){
                byte[] buffer=new byte[4096];
                int len;

                while ((len=is.read(buffer,0,4096))!=-1){
                    decrypt(buffer, 0, len, secretKey);

                    os.write(buffer,0,len);
                }
                os.flush();
            }
        }
    }
    private static byte calcSecretKey(String secretKey) throws UnsupportedEncodingException {
        byte k = 0;
        for (byte b : secretKey.getBytes("UTF-8")) {
            k += b;
        }

        return k;
    }

    private static void decrypt(byte[] buffer,int offset,int len,String secretKey) throws UnsupportedEncodingException {

        for(int i=0;i<len;i++){
            buffer[i+offset]= (byte)(buffer[i + offset] -calcSecretKey(secretKey));
        }
    }
}
