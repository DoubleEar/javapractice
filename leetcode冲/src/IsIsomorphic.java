import java.util.HashMap;
import java.util.Map;
//给定两个字符串 s 和 t，判断它们是否是同构的。
public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
        //不能只判断一边。比如"ab""cc"->a映射c,b映射c。但是反过来就不对了。
        return is_Isomorphic(s, t) && is_Isomorphic(t, s);

        //return is_Isomorphic(s).equals(is_Isomorphic(t));
    }


    private static boolean is_Isomorphic(String s,String t){
        int len=s.length();
        Map<Character,Character> map=new HashMap<>();
        for(int i=0;i<len;i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1)!=c2){
                    return false;
                }
            }else{
                map.put(c1,c2);
            }
        }
        return true;

    /*
    private static String is_Isomorphic(String s) {
        //将两个字符串映射成整型再判断。
        int[] map=new int[128];
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            //ab被映射为12  cc被映射为11
            if(map[c]==0){
                map[c]=i+1;
            }
            stringBuilder.append(map[c]);
        }
        return stringBuilder.toString();
        */
    }

    public static void main(String[] args) {
        String s="ab";
        String t="cc";
        System.out.println(isIsomorphic(s,t));
    }
}
