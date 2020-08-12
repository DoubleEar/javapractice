import java.util.Scanner;
//大数乘法
public class MultOfLargeNum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String num1=sc.next();
        String num2=sc.next();
        String res=mul(num1,num2);
        System.out.println(res);
    }

    private static String mul(String num1, String num2) {
        //把字符串转换成char数组
        char chars1[] = num1.toCharArray();
        char chars2[] = num2.toCharArray();
        //声明存放结果和两个数的容器
        int result[] = new int[chars1.length + chars2.length];
        int n1[] = new int[chars1.length];
        int n2[] = new int[chars2.length];
        //把char转换成int数组
        for(int i = 0; i < chars1.length;i++)
            n1[i] = chars1[i]-'0';
        for(int i = 0; i < chars2.length;i++)
            n2[i] = chars2[i]-'0';
        //逐个相乘，因为你会发现。AB*CD = AC(BC+AD)BD , 然后进位。
        for(int i =0 ; i < chars1.length; i++){
            for(int j =0; j < chars2.length; j++){
                result[i+j]+=n1[i]*n2[j];
            }
        }
        //满10进位，从后往前满十进位
        for(int i =result.length-1; i > 0 ;i--){
            result[i-1] += result[i] / 10;
            result[i] = result[i] % 10;
        }
        //转成string并返回
        String resultStr = "";
        for(int i = 0; i < result.length-1; i++){
            resultStr+=""+result[i];
        } return resultStr;
    }
}
