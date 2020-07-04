import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
//第一个只出现一次的字符
public class FirstUniqueChar {
    /*
    public static char firstUniqueChar(String s) {
        char[] sc=s.toCharArray();
        Map<Character,Integer> map=new LinkedHashMap<>();
        for(char c:sc)
            map.put(c,map.getOrDefault(c,0)+1);
        for(Map.Entry<Character,Integer> element:map.entrySet()){
            if(element.getValue()==1)
                return element.getKey();
        }
        return ' ';
    }
    */


    public static char firstUniqueChar(String s) {
        char[] sc=s.toCharArray();
        //保证哈希表的有序性 value布尔值表示哈希表中有没有对应的key
        Map<Character,Boolean> map=new LinkedHashMap<>();
        for(char c:sc)
            map.put(c,!map.containsKey(c));
        //遍历哈希表 出现一次的key->value=true
        //哈希表保证key的唯一性，因此在出现重复的字符时，可以减少查找次数。
        for(Map.Entry<Character,Boolean> element:map.entrySet()){
            if(element.getValue())
                return element.getKey();
        }
        return ' ';
    }

    /*
    public char firstUniqueChar(String s) {
        char[] sc=s.toCharArray();
        //因为此次操作没有遍历哈希表的操作，所以不用保证哈希表有序。
        Map<Character,Boolean> map=new HashMap<>();
        for(char c:sc)
            map.put(c,!map.containsKey(c));
        for(char c:sc){ //遍历字符数组
            if(map.get(c))
                return c;
        }
        return ' ';
    }
    */

    public static void main(String[] args) {
        String s="leetcode";
        System.out.println(firstUniqueChar(s));
    }
}
