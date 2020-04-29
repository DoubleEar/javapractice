import java.util.Scanner;

public class ExchangeIP {
    //将IP地址转换为对应的十进制数
    private static long exchangeNum(String ip){
        String[] ipNum=ip.split("\\.");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ipNum.length;i++){
            //先将十进制数转为二进制
            String res=Integer.toBinaryString(Integer.valueOf(ipNum[i]));

            //如果不够8位，就用0补齐(除了第一个字符数组外)
            while (res.length()!=8&&i!=0){
                res="0"+res;
            }
            sb.append(res);
        }
        //返回对应的十进制数
        return Long.parseLong(sb.toString(),2);    //String代表的是2进制数，默认输出十进制数。
    }

    //将对应的十进制数转换为IP地址
    private static String exchangeIP(String num){
        Long res=Long.parseLong(num);   //保存十进制数
        String ip=Long.toBinaryString(res); //将十进制数转换为二进制
        StringBuilder sb=new StringBuilder();

        while (ip.length()%8!=0){   //用0补齐
            ip="0"+ip;
        }

        for(int i=0;i<ip.length();i+=8){    //每隔8位分割
            String temp=ip.substring(i,i+8);
            sb.append(Long.parseLong(temp,2)+".");
        }
        //将最后一个点割掉
        return sb.toString().substring(0,sb.toString().length()-1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String ip=sc.nextLine();
            String number=sc.nextLine();

            System.out.println(exchangeNum(ip));
            System.out.println(exchangeIP(number));
        }
    }
}
