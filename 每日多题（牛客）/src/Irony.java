import java.util.Scanner;

//说反话
public class Irony {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(s==null){
            System.out.println(" ");
        }
        String[] s1=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=s1.length-1;i>=0;i--){
            if(i==0){
                sb.append(s1[i]);
            }else {
                sb.append(s1[i] + " ");
            }
        }
        System.out.println(sb.toString());
    }
}
