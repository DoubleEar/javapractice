//左旋转字符串
//"abcdefg" 左旋两位-> "cdefgab"
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        //切割字符串
        //return s.substring(n,s.length())+s.substring(0,n);
        StringBuilder sb=new StringBuilder();
        for(int i=n;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        for(int i=0;i<n;i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
