import java.util.Scanner;
//奇偶校验
public class ParityChecks {
    //这一题里面将数字和字母统一看成是char类型的
    // 如数字3实际存储时为ASCII码中的‘3’，其十进制表示是51
    // 转化为二进制表示就是0110011。
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            char[] c=s.toCharArray();
            for(char ch:c){
                String s1=Integer.toBinaryString(ch);   //先将字符转换成相应的二进制
                String s2=String.format("%07d",Integer.parseInt(s1));   //保留7位
                int count=0;
                //进行奇校验，使得二进制中1的个数为奇数
                for(int i=0;i<7;i++){
                    if(s2.charAt(i)=='1')
                        count++;
                }
                System.out.println(count%2==0?"1"+s2:"0"+s2);
            }
        }
    }
}
