//在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
// 如果不存在，则返回  -1。
public class StrStr {
    public static int strStr(String haystack, String needle) {
        /*
        //方法一
        int len1=haystack.length();
        int len2=needle.length();

        //不断的切割字符串和needle进行比较
        for(int i=0;i<(len1-len2+1);i++){
            if(haystack.substring(i,i+len2).equals(needle)){
                return i;
            }
        }
        return -1;
        */


        //方法二
        int len1=haystack.length();
        int len2=needle.length();

        if(len2==0)
            return 0;
        int ph=0;
        while (ph<(len1-len2+1)){
            //找到haystack中与needle第一个字符相同的位置
            while (ph<(len1-len2+1)&&haystack.charAt(ph)!=needle.charAt(0)){
                ph++;
            }

            int pn=0;
            int curLen=0;
            //一个字符一个字符比较haystack中是否包含needle，有一个不一样就退出循环。
            while (ph<len1&&pn<len2&&haystack.charAt(ph)==needle.charAt(pn)) {
                ph++;
                pn++;
                curLen++;
            }

            //判断字符串长度是否与needle长度相等
            if(curLen==len2)
                return ph-curLen;

            //如果不相等就回溯
            ph=ph-curLen+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack,needle));
    }
}
