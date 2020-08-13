//是否为句子单词中的前缀
public class MatchStrInSentence {
    private static boolean preIndex(String s,String x){
        int len=x.length();
        for(int i=0;i<len;i++){
            if(x.charAt(i)!=s.charAt(i))
                return false;
        }
        return true;
    }
    public static int match_str_in_sentence (String s, String x) {

        String[] str=s.split(" ");
        for(int i=0;i<str.length;i++){
            if(str[i].equals(x))
                return -1;
            if(str[i].contains(x)){
                if(preIndex(str[i],x))
                    return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s="this is an easy problem.";
        String x="eas";
        System.out.println(match_str_in_sentence(s, x));
    }
}
