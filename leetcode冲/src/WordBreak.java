import java.util.HashSet;
import java.util.Set;
//字符串分割
//给定一个字符串和一个词典dict，确定s是否可以根据词典中的词分成一个或多个单词。
// 比如，给定s = "leetcode"dict = ["leet", "code"]返回true。
public class WordBreak {
    /*
         F(i): 前i个字符能否根据词典中的词被成功分词
         F(i): j <i && F(j) && subString[j,i]
         在j小于i中，只要能找到一个F(j)为true，并且从j+1到i之间的字符能在词典中找到，则F(i)为true
     */
    public static boolean wordBreak(String s, Set<String> dict) {
        boolean[] canBreak=new boolean[s.length()+1];
        //空状态，用来判断包含当前遍历到的字符以及之前所有的字符组成的字符串是否可以被分割的
        canBreak[0]=true;

        for(int i=1;i<=s.length();i++){
            for(int j=i-1;j>=0;j--){
                //判断之前的字符串以及substring(j,i)是否都可以被分割
                if(canBreak[j]&&dict.contains(s.substring(j,i))){
                    canBreak[i]=true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> set=new HashSet<>();
        set.add("leetcode");
        //set.add("code");

        System.out.println(wordBreak(s,set));
    }
}
