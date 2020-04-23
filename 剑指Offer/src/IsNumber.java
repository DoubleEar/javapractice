//表示数值的字符串
public class IsNumber {
    /*
    核心: 有效数字的模式只有两种:
    1)A[.[B]][e|EC]  比如: +100   -67.0  29.    3.14E5
    2).B[e|EC]       比如: .3     .4E6
    其中,A、C是整数，B是正整数; [e|EC]表示[eC]或者[EC]
    原则: 有A的话,有没有B都可以; 没有A的话, 必须有B
    */

    static int i=0;    //扫描字符串时的索引

    //扫描整数
    private static boolean scanInteger(String s){
        //判断是否有'+'或者'-'
        if(i<s.length()&&(s.charAt(i)=='+'||s.charAt(i)=='-'))
            i++;
        //扫描正整数
        return scanUnsignedInteger(s);
    }

    //扫描正整数
    private static boolean scanUnsignedInteger(String s){
        int start=i;    //起始索引
        while (i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9')
            i++;
        //i>start说明扫描到了数字;
        //i<=start说明没有扫描到数字, 此种情况说明要么start越界, 要么s.charAt(start)不是数字
        return i>start;
    }

    public static boolean isNumber(String s) {
        if(s==null||s.length()==0)
            return false;

        ////判断是否有A; 同时将B,C初始化为false
        boolean A=scanInteger(s),B=false,C=false;

        //判断是否有B; 使用索引时要确保索引不越界
        if(i<s.length()&&s.charAt(i)=='.') {
            //i当前指向'.', 所以需要i++
            i++;
            B = scanUnsignedInteger(s);
        }

        //判断是否有C
        if(i<s.length()&&(s.charAt(i)=='e'||s.charAt(i)=='E')){
            i++;
            C=scanInteger(s);

            ////如果存在e|E, 但是没有C, 说明不是数字
            if(C==false)
                return false;
        }

        //说明C是合格的, 只需判断A和B的情况
        //i必须扫描完整个字符串 && (有A的话,有没有B都可以; 没有A的话, 必须有B)
        return i==s.length()&&(A||B);
    }

    public static void main(String[] args) {
        System.out.println(isNumber("-100"));
    }
}
