//构造最长的回文串
public class LongestPalindrome {
    public static int longestPalindrome(String s){
        //字符的 ASCII 值的范围为 [0, 128)
        int[] count=new int[128];
        for(char c:s.toCharArray()){
            count[c]++;
        }

        /*
        回文串中每个字符出现都是偶数次，如果有奇数，那么只能有一个字符为奇数，作为回文串的中心。
         */
        int res=0;
        for(int i:count){
            //res+=i%2; 代表奇数出现的次数

            //res代表i能使用的次数。
            res+=i/2*2;
            //如果res一直为偶数（证明没有出现过基数），i为出现的第一个奇数次字符。就将res++。
            if(res%2==0&&i%2==1){
                res++;
            }
        }
        // 没有出现奇数的字符，返回字符串长度，否则只保留一个奇数的字符。
        //return res==0?s.length():(s.length()- res+1);

        return res;
    }

    public static void main(String[] args) {
        String s="abccccdd";
        System.out.println(longestPalindrome(s));
    }
}
