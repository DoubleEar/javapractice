import java.util.Scanner;
//将整数以字符串形式逆序输出
public class BackWardNumber {
    private static String backWard(char[] c){
        StringBuilder sb=new StringBuilder();
        for(int i=c.length-1;i>=0;i--){
            sb.append(c[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            char[] c=s.toCharArray();
            System.out.println(backWard(c));
        }
    }
}
