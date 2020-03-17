import java.util.HashMap;
import java.util.Map;

//假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
//注意：每次拼写时，chars 中的每个字母都只能用一次。
//返回词汇表 words 中你掌握的所有单词的 长度之和。

public class CountCharacters {
    public static int countCharacters(String[] words, String chars) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:chars.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int res=0;
        for(int i=0;i<words.length;i++){
            int len=words[i].length();
            int j=0;
            //每遍历一次就重新克隆一份map，在temp上进行操作。
            //注意：不能再原map上进行操作，影响下一个单词的拼写。
            HashMap<Character,Integer> temp= (HashMap<Character, Integer>) ((HashMap<Character, Integer>) map).clone();
            while (j<len){
                if(map.containsKey(words[i].charAt(j))&&temp.get(words[i].charAt(j))>0){
                    //对应字符减一
                    temp.put(words[i].charAt(j),temp.get(words[i].charAt(j))-1);
                    j++;
                }else
                    break;
            }
            //如果j等于单词的长度 就说明掌握了该单词
            if(j==len)
                res+=len;
            }
            return res;
    }
    /*
    public static int countCharacters(String[] words, String chars) {
        int res=0;
        char[] c=new char[26];
        //统计每个字母出现的次数
        for(char ch:chars.toCharArray()){
            c[ch-'a']++;
        }
        //遍历单词
        for(String str:words){
            boolean flag=true;
            //如果单词的长度大于给定字母的个数，直接break。
            if(str.length()>c.length) {
                flag=false;
            }else{
                //定义一个临时的字符数组，统计每个单词中某个字母出现的次数。
                char[] temp=new char[26];
                for(char a:str.toCharArray()){
                    temp[a-'a']++;
                    //如果单词中字母的个数大于给定字母的个数，就break；
                    if(temp[a-'a']>c[a-'a']){
                        flag=false;
                        break;
                    }
                }
            }
            if(flag)
                res+=str.length();
        }
        return res;
    }
    */
    public static void main(String[] args) {
        String[] words={"hello","world","leetcode"};
        String chars="welldonehoneyr";
        System.out.println(countCharacters(words,chars));
    }
}
