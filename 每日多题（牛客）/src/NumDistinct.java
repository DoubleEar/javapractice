//不同子序列
//给定一个字符串S和一个字符串T，计算S中的T的不同子序列的个数。
//字符串的子序列是由原来的字符串删除一些字符（也可以不删除）
// 在不改变相对位置的情况下的剩余字符。
public class NumDistinct {
    /*  状态：F(i,j): S[1:i]中的子串与T[1:j]相同的个数
        状态递推：  
        在F(i,j)处需要考虑S[i] = T[j] 和 S[i] != T[j]两种情况  
        当S[i] = T[j]:    
        1>: 让S[i]匹配T[j]，则F(i,j) = F(i-1,j-1)    匹配时相等的字符只能在最后一位
        2>: 让S[i]不匹配T[j],则问题就变为S[1:i-1]中的子串与T[1:j]相同的个数，则F(i,j) = F(i-1,j)  
        故，S[i] = T[j]时，F(i,j) = F(i-1,j-1) + F(i-1,j)    
        当S[i] != T[j]：
        故，S[i] != T[j]时，F(i,j) = F(i-1,j)
     */
    public static int numDistinct (String S, String T) {
        int s1=S.length();
        int t1=T.length();

        int[][] res=new int[s1+1][t1+1];

        //初始化第一行
        for(int i=1;i<=t1;i++){
            res[0][i]=0;
        }

        //初始化第一列 空串是一个字符串的子集 如：S="ccc" T="c" s[i]==t[j]会看前一列。
        for(int i=0;i<=s1;i++){
            res[i][0]=1;
        }

        for(int i=1;i<=s1;i++){
            for(int j=1;j<=t1;j++){
                if(S.charAt(i-1)==T.charAt(j-1))    //相等
                    //匹配与不匹配
                    res[i][j]=res[i-1][j-1]+res[i-1][j];
                else
                    //不相等
                    res[i][j]=res[i-1][j];
            }
        }
        return res[s1][t1];
    }

    public static void main(String[] args) {
        String S="";
        String T="a";

        System.out.println(numDistinct(S,T));
    }
}
