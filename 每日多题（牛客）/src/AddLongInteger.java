import java.math.BigInteger;
import java.util.Scanner;
//超长正整数相加
public class AddLongInteger {
    private static void addLongInteger(String s1,String s2){
        int lenS1=s1.length();
        int lenS2=s2.length();
        int lenS=Math.max(lenS1,lenS2);//求出两个数中较长的长度

        int[] A=new int[lenS];//用较长的数的长度创建数组
        int[] B=new int[lenS];
        int[] S=new int[lenS+1];//用来保存两个数的和，多一位为了进位。

        //倒序将数字存入数组中（注意i的上界，否则会导致数组下标越界）
        //倒序为了避免进位
        for(int i=0;i<lenS1;i++){
            A[i]=s1.charAt(lenS1-1-i)-'0';
        }

        for(int i=0;i<lenS2;i++){
            B[i]=s2.charAt(lenS2-1-i)-'0';
        }

        //计算对应位的值放入S中
        for(int i=0;i<lenS;i++){
            //求和
            int sum=A[i]+B[i]+S[i];
            //和 除10的结果用来进位
            int division=sum/10;
            //求出两数相加后的个位数
            S[i]=sum%10;
            S[i+1]+=division;
        }

        //如果S最后一位为零说明最后一位闲置->i=1
        // （因为-i，所以意味着从倒数第二位开始倒序输出）
        //S最后一位不为零说明进位了->i=0
        //（因为-i，所以意味着从最后一位开始倒序输出）
        for(int i=(S[lenS]==0?1:0);i<S.length;i++){
            System.out.print(S[lenS-i]);//因为S的长度为lenS+1，所以这就不用在-1。
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            addLongInteger(s1,s2);
        }
    }

    /*
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String s1=input.next();
            String s2=input.next();
            BigInteger num1=new BigInteger(s1);//采用BigInteger可以直接进行大整数进行计算
            BigInteger num2=new BigInteger(s2);
            System.out.println(num1.add(num2));
        }
    }
    */
}
