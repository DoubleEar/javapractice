import java.util.Scanner;
//将输入的英文句子逆序输出
public class ReverseSentenceOrder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] s=sc.nextLine().split(" ");
            StringBuilder sb=new StringBuilder();
            for(int i=s.length-1;i>=0;i--){
                if(i!=0){
                    sb.append(s[i]+" ");
                }else
                    sb.append(s[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
