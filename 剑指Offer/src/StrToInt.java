public class StrToInt {
    //把字符串转换成整数
    /*
    public static int strToInt(String str) {
        if(str==null||str.length()==0)
            return 0;

        char[] c=str.trim().toCharArray();
        if(c.length==0)
            return 0;

        int sign=1,i=1;     //sign用来判断该数是正数还是负数
        int boundary=Integer.MAX_VALUE/10,res=0;    //防止越界的边界值
        if(c[0]=='-')
            sign=-1;
        else if(c[0]!='+')  //如果开始不是+从头开始遍历
            i=0;

        for(int j=i;j<c.length;j++){
            if(c[j]<'0'||c[j]>'9')  //遇到非数字的字符，就直接break
                break;
            if(res>boundary||(res==boundary&&c[j]>'7')) //判断有没有越界的可能
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;

            res=res*10+(c[j]-'0');  //更新res
        }

        return sign*res;
    }
    */

    public static int strToInt(String str) {
        //降低空间复杂度
        if(str==null||str.length()==0)
            return 0;

        int sign=1,i=0,res=0;
        int len=str.length(),boundary=Integer.MAX_VALUE/10;

        if(len==0)
            return 0;

        while (str.charAt(i)==' ')  //去除字符串首部的空格
            if(++i==len)
                return 0;

        if(str.charAt(i)=='-')
            sign=-1;
        if(str.charAt(i)=='+'||str.charAt(i)=='-')
            i++;

        for(int j=i;j<len;j++){
            if(str.charAt(j)<'0'||str.charAt(j)>'9')
                break;

            if(res>boundary||(res==boundary&&str.charAt(j)>'7'))
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;

            res=res*10+(str.charAt(j)-'0');
        }
        return sign*res;
    }

    public static void main(String[] args) {
        System.out.println(strToInt("4193 with words"));
    }
}
