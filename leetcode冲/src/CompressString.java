//字符串压缩。字符串aabcccccaaa会变为a2b1c5a3.
public class CompressString {
    public static String compressString(String S) {
        int len=S.length();
        int i=0,j=0;
        //定义一个可变字符序列
        StringBuilder sb=new StringBuilder();
        while (i<len){
            //当S.charAt(j)==S.charAt(i)
            while (j<len&&S.charAt(j)==S.charAt(i))
                //j后移，一直到不是相同值元素为止
                j++;
            //sb加入i
            sb.append(S.charAt(i));
            //sb加入与i对应的字符相等的个数
            sb.append(j-i);
            //将i移动到j：即下一个新的值开始的位置
            i=j;
        }
        String res=sb.toString();
        //返回长的更小的字符串
        return res.length()<S.length()?res:S;
    }

    public static void main(String[] args) {
        String s="1,1,2,2,2,3,3,5,5,5";
        System.out.println(compressString(s));
    }
}
