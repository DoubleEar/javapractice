import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyPicture {
    public static void main(String[] args)throws IOException {
        File file1=new File("E:/photo.jpg");
        FileInputStream input=new FileInputStream("E:/photo.jpg");
        FileOutputStream output=new FileOutputStream("E:/c.jpg");
        byte[] b=new byte[(int)file1.length()];
        while(input.read(b)!=-1){
            output.write(b);
        }
        input.close();
        output.close();
    }
}
