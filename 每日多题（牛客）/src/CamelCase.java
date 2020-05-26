import java.util.Scanner;
//驼峰命名法
//hello_world-->helloWorld
public class CamelCase {
    private static void transferName(String s){
        StringBuilder sb=new StringBuilder();
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='_'){
                sb.append((char)(c[i+1]-32));
                i++;
            }else
                sb.append(c[i]);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            transferName(s);
        }
    }
}
