import java.io.*;

public class FileCopyByLine {
    public static void main(String[] args)throws IOException {
        FileReader input=new FileReader("E:/a.txt");
        BufferedReader br=new BufferedReader(input);
        FileWriter output=new FileWriter("E:/b.txt");
        BufferedWriter bw=new BufferedWriter(output);

        String s= br.readLine();
        while(s!=null){
            bw.write(s);
            //换行
            bw.newLine();
            System.out.println(s);
            s=br.readLine();
        }
        br.close();
        bw.close();
    }
}
