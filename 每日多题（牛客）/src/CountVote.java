import java.util.*;

//记票统计
public class CountVote {
    private static void countVote(Map<String,Integer> map,String[] voters){
        for(String s:voters){   //遍历投票情况
            if(map.containsKey(s))
                map.put(s,map.get(s)+1);
            else
                map.put("Invalid",map.get("Invalid")+1);
        }

        //获取key的集合
        Set<String> set=map.keySet();
        for(String s:set){
            System.out.println(s+" : "+map.get(s)); //输出key与对应的value
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            //LinkedHashMap保存了记录的插入顺序
            Map<String,Integer> map=new LinkedHashMap<>();//保存选举人

            for(int i=0;i<n;i++){
                map.put(sc.next(),0);
            }
            map.put("Invalid",0);

            int m=sc.nextInt();
            sc.nextLine();
            String s=sc.nextLine();
            String[] voters=s.split(" ");//投票情况
            countVote(map,voters);
        }
    }
}
