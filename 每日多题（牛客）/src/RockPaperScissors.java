import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//石头剪刀布
public class RockPaperScissors {
    private static void checkWinner(String[] s,int n){
        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();
        map1.put("C",0);
        map1.put("J",0);
        map1.put("B",0);
        map2.put("C",0);
        map2.put("J",0);
        map2.put("B",0);
        int winNum=0;
        int loseNum=0;
        int tieNum=0;

        for(int i=0;i<n;i++){
            String[] str=s[i].split(" ");
            if(str[0].equals("C")){
                if(str[1].equals("B")) {
                    loseNum++;
                    map2.put("B",map2.get("B")+1);
                }else if(str[1].equals("J")) {
                    winNum++;
                    map1.put("C",map1.get("C")+1);
                }
                else
                    tieNum++;
            }else if(str[0].equals("J")){
                if(str[1].equals("B")) {
                    winNum++;
                    map1.put("J",map1.get("J")+1);
                }else if(str[1].equals("C")) {
                    loseNum++;
                    map2.put("C",map2.get("C")+1);
                }else
                    tieNum++;
            }else if(str[0].equals("B")){
                if(str[1].equals("C")) {
                    winNum++;
                    map1.put("B",map1.get("B")+1);
                }else if(str[1].equals("J")) {
                    loseNum++;
                    map2.put("J",map2.get("J")+1);
                }else
                    tieNum++;
            }
        }
        System.out.println(winNum+" "+tieNum+" "+loseNum);
        System.out.println(loseNum+" "+tieNum+" "+winNum);
        System.out.println(getMax(map1)+" "+getMax(map2));
    }

    private static String getMax(Map<String,Integer> map){
        if(map.get("C")>=map.get("J")){
            if(map.get("C")>map.get("B")){
                return "C";
            }else
                return "B";
        }else {
            if(map.get("J")>map.get("B"))
                return "J";
            else
                return "B";
            }
        }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            sc.nextLine();
            String[] s=new String[n];
            for(int i=0;i<n;i++){
                s[i]=sc.nextLine();
            }
            checkWinner(s,n);
        }
    }
}
