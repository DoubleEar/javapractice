import java.io.*;
public class FileWriterTest {
    public static void main(String[] args)throws IOException {
        String s;
        //BufferedReader不能直接对文件，缓冲处理流
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //一行一行读
        s = in.readLine();
        FileWriter fw = new FileWriter("E:/a.txt");
        fw.write(s);
        fw.close();
        System.out.println(s);
    }
}


