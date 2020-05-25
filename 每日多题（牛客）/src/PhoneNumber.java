import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//电话号码
//九键对应的字母转换为数字组成电话号码
public class PhoneNumber {
    private static void transferNumber(String[] s,int n,List<String> list){
        String character="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number="222333444555666777788899991234567890";
        for(int i=0;i<n;i++){
            String result="";
            for(int j=0;j<7;j++){   //美国的电话号码为7位，只取输入的前七位。

                //找到输入的字符对应的下标->找到对应的数字
                result+=number.charAt(character.indexOf(s[i].charAt(j)+""));
            }

            //前三位于后四位之间用"-"连接
            result=result.substring(0,3)+"-"+result.substring(3,7);

            if(!list.contains(result)){
                list.add(result);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            sc.nextLine();
            String[] s=new String[n];
            List<String> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                s[i]=sc.nextLine();

                //去除输入中的"-"
                s[i]=s[i].replace("-","");
            }

            transferNumber(s,n,list);


            //按照字典序输出
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
            System.out.println();
        }
    }
}
