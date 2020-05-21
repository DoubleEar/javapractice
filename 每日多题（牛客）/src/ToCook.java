import java.util.*;
//下厨房
//每一行输入都代表着 一种料理所需要的材料
//输出完成所有的料理共需要几种材料
public class ToCook {
    private static int countMaterial(List<String> list){
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<list.size();i++){
            String[] s=list.get(i).split(" ");
            for(int j=0;j<s.length;j++){
                map.put(s[j],map.getOrDefault(s[j],0)+1);
            }
        }
        return map.size();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String> list=new ArrayList<>();
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            list.add(s);
        }
        System.out.println(countMaterial(list));


        /*
        Scanner sc=new Scanner(System.in);
        Set<String> set=new HashSet<>();
        while (sc.hasNextLine()){
            String[] s=sc.nextLine().split(" ");
            for(int i=0;i<s.length;i++){
                set.add(s[i]);
            }
        }
        System.out.println(set.size());
        */
    }
}
