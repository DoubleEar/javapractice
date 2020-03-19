import java.util.HashMap;
import java.util.Map;

//字符串中的第一个唯一字符
public class FirstUniqChar {
    public static int firstUniqChar(String s) {

        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1)
                return i;
        }
        return -1;

        /*
        int[] count=new int[26];
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)-'a']++;

        for(int i=0;i<s.length();i++){
            //取到该下标对应的字母的个数
            if(count[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
        */
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
}
