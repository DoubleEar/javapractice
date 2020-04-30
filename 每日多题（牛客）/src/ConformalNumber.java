import java.util.Scanner;
//守形数
//25的平方是625，低位部分是25，因此25是一个守形数
public class ConformalNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            int pow=(int)Math.pow(n,2);
            //先将平方转化位字符串
            String s=""+pow;
            //除去平方的最高位
            String res=s.substring(1);
            if(res.length()>0){
                int temp=Integer.valueOf(res);
                if(temp==n)
                    System.out.println("Yes!");
                else
                    System.out.println("No!");
            }else   //对于1 2 3平方进行分割后长度变为0
                System.out.println("No!");
        }
    }
}
