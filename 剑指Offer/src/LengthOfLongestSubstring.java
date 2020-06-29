import java.util.HashMap;
import java.util.Map;

//最长不含重复字符的子字符串
public class LengthOfLongestSubstring {
    /*
        状态定义： 设动态规划列表dp,dp[i]表示以字符s.charAt(i)为结尾的“最长不重复子字符串”最大长度。
        转移方程：dp[i]=dp[i-1]+1;
        如果s.charAt(i)之前出现过，计算出两个相同字符之间的距离d。
        (1)如果d<=dp[i-1]-->dp[i]=d;
        (2)如果d>dp[i-1]-->dp[i]=dp[i-1]+1;
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxLen=0;   //最长不重复子字符串的长度
        int curLen=0;   //当前长度
        Map<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            int index=map.getOrDefault(s.charAt(i),-1); //获取之前该字符的索引
            map.put(s.charAt(i),i); //更新哈希表
            curLen=curLen<i-index?curLen+1:i-index; //dp[i-1]-->dp[i];
            maxLen=Math.max(curLen,maxLen);    //dp[i]=max(dp[i-1],dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s="arabcacfr";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
