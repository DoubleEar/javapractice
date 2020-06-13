//编辑距离
public class MinDistance {
    /*
       给定两个单词word1和word2，找到小的修改步数，把word1转换成word2
       每一个操作记为一步  允许在一个word上进行如下3种操作：  
       a) 插入一个字符  b) 删除一个字符  c) 替换一个字符  
       编辑距离（Edit Distance）：
       是指两个字串之间，由一个转成另一个所需的少编辑操作次数。
     */
    public static int minDistance (String word1, String word2) {
        //F(i,j):word1的前i个字符于word2的前j个字符的编辑距离
        //删除w1[i]的字符--->F(i,j)：F(i-1,j)
        //增加一个字符--->F(i,j)：F(i,j-1)
        //替换w1[i]的字符为w2[j]--->F(i,j)：F(i-1,j-1)
        // 如果w1[i]与w2[j]相同，不做任何操作，编辑距离不变。
        if(word1==null||word2==null){
            return Math.min(word1.length(),word2.length());
        }

        int s1=word1.length();
        int s2=word2.length();

        int[][] minDis=new int[s1+1][s2+2];

        //初始化 第0列代表word与空串(s2为空)的编辑距离，一直删除操作。
        for(int i=0;i<=s1;i++){
            minDis[i][0]=i;
        }
        //初始化 第0行代表空串(s1为空)与word的编辑距离，一直增加操作。
        for(int i=0;i<=s2;i++){
            minDis[0][i]=i;
        }

        for(int i=1;i<=s1;i++){
            for(int j=1;j<=s2;j++){
                //先初始化为替换操作的值
                //判断当前两个字符是否相等
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                     minDis[i][j]=minDis[i-1][j-1];     //不替换
                }else{
                    minDis[i][j]=minDis[i-1][j-1]+1;    //做一次替换操作
                }

                //与删除和插入的操作 作比较。
                minDis[i][j]=Math.min(minDis[i][j],1+Math.min(minDis[i-1][j],minDis[i][j-1]));
            }
        }
        return minDis[s1][s2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("leet", "code"));
    }
}
