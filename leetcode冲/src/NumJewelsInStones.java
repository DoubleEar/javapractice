import java.util.HashSet;
import java.util.Set;

//J (宝石)中的字母不重复，J 和 S（石头）中的所有字符都是字母。
// 字母区分大小写，因此"a"和"A"是不同类型的石头。
public class NumJewelsInStones {
    public static int numJewelsInStones(String J, String S) {
        Set<Character> set=new HashSet<>();
        for(char ch:J.toCharArray()){
            set.add(ch);
        }
        int count=0;
        for(char ch:S.toCharArray()){
            if(set.contains(ch))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s1="Ab";
        String s2="Aabbb";
        System.out.println(numJewelsInStones(s1,s2));
    }
}
