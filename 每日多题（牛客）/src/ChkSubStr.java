import java.util.Arrays;
//字符串判断，给定一个字符串数组和它的长度，判断p中每一个较短的字符串是否为s的字串。
public class ChkSubStr {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] b=new boolean[n];
        for(int i=0;i<n;i++){
            if(s.contains(p[i])) {
                b[i]=true;
            }else
                b[i]=false;
        }
        return b;
    }

    public static void main(String[] args) {
        String[] p={"a","b","c","d",};
        String s="abc";
        System.out.println(Arrays.toString(chkSubStr(p,4,s)));
    }
}
