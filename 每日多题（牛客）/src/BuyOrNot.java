import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；
// 如果不可以买，则在一行中输出“No”以及缺了多少珠子。
public class BuyOrNot {
    private static void judge(String src,String des){
        char[] c1=src.toCharArray();
        char[] c2=des.toCharArray();
        Map<Character,Integer> map=new HashMap<>();//存储商家卖的珠子
        for(char ch:c1){
            //key->珠子  value->对应珠子的个数
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int count=0;
        for(char ch:c2){
            if(map.containsKey(ch)){//如果包含小红想要的珠子
                if(map.get(ch)>0) {
                    //如果该珠子的数量大于1，将该珠子的数量减1。
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                }else{
                    //证明珠子数量不够，计入缺的珠子个数
                    count++;
                }
            }else {     //不包含小红想要的珠子数
                count++;
            }
        }

        if(count==0){   //小红想要的珠子都有，可以买。
            System.out.println("Yes"+" "+(c1.length-c2.length));
        }else{
            System.out.println("No"+" "+count);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String src=sc.nextLine();
            String des=sc.nextLine();
            judge(src,des);
        }
    }
}
