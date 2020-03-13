package MapSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//坏键盘打字
public class TestMapSet {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String right=sc.nextLine();//保存正确的输入
        String error=sc.nextLine();//保存返回的错误的结果

        Set<Character> setPrint=new HashSet<>();
        Set<Character> setError=new HashSet<>();

        //将错误的结果存在setError
        for(char ch:error.toCharArray()){
            setError.add(ch);
        }

        //遍历正确的输入
        for(char ch:right.toCharArray()){
            //如果错误的结果中不包含正确输入的字符
            if(!setError.contains(ch)){
                //注意大小写
                ch=Character.toUpperCase(ch);
                //判断这个错误的字符有没有打印过
                if(!setPrint.contains(ch)){
                    //如果没有打印过，就输出该错误字符的大写。
                    System.out.print(ch);
                    setPrint.add(ch);
                }
            }
        }
        System.out.println();
    }
}
