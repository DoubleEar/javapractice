import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//活字印刷
public class NumTilePossibilities {
    //你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。
    // 返回你可以印出的非空字母序列的数目。
    private static void DFS(String titles,List<Integer> list,StringBuilder curStr,Set<String> totalString){
        if(curStr.length()!=0)   //只要非空，就加进去。
            totalString.add(curStr.toString());

        for(int i=0;i<titles.length();i++){
            if(list.get(i)==1)      //标记当前坐标有没有被使用
                continue;
            list.set(i,1);      //使用之后，进行标记。
            DFS(titles,list,curStr.append(titles.charAt(i)),totalString);
            //回溯
            list.set(i,0);
            //删除最后一个字符
            curStr.deleteCharAt(curStr.length()-1);
        }
    }

    public static int numTilePossibilities(String tiles) {
        if(tiles==null||tiles.length()==0)
            return 0;
        Set<String> totalString=new HashSet<>();    //保存所有的结果，set不重复。
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<tiles.length();i++){     //先将所有的坐标全部置为0。
            list.add(0);
        }

        StringBuilder curStr=new StringBuilder();   //用于拼接字符串

        DFS(tiles,list,curStr,totalString);

        return totalString.size();
    }

    public static void main(String[] args) {
        String titles="AAB";
        System.out.println(numTilePossibilities(titles));
    }
}
