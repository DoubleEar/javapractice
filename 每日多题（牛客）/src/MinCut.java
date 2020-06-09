//回文串分割
// 给定一个字符串 s,把 s 分割成一系列的子串，分割的每一个子串都为回文串，返回小的分割次数。
// 比如，给定 s = "aab",  返回1，因为一次cut就可以产生回文分割["aa","b"]
public class MinCut {
    //  F(i): 到第i个字符需要的小分割数
    // F(i) = min{F(i), 1 + F(j)}  j<i && j+1到i是回文串  
    // 上式表示如果从j+1到i判断为回文字符串，且已经知道从第1个字符  
    // 到第j个字符的小切割数，那么只需要再切一次，就可以保证  1-->j, j+1-->i都为回文串。
    private boolean isPal(String s,int start,int end){
        while (start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    /*
    public int minCut(String s) {
        int len=s.length();

        if(len==0)
            return 0;
        int[] minCut=new int[len+1];

        for(int i=1;i<=len;i++){
            minCut[i]=i-1;
        }

        for(int i=2;i<=len;i++){    //遍历每一种状态 前i个字符的最小分割次数
            //整体是否为回文串
            if(isPal(s,0,i-1)){
                minCut[i]=0;
                continue;
            }
            //i<j
            for(int j=1;j<i;j++){   //遍历前i个字符的每一种分割情况
                //[j+1,i]是否为回文串
                if(isPal(s,j,i-1)){
                    minCut[i]=Math.min(minCut[j]+1,minCut[i]);
                }
            }
        }
        return minCut[len];
    }
    */

    public int minCut(String s) {
        int len=s.length();

        if(len==0)
            return 0;
        int[] minCut=new int[len+1];

        //初始化 使用辅助状态
        for(int i=0;i<=len;i++){
            minCut[i]=i-1;
        }

        for(int i=2;i<=len;i++){
            for(int j=0;j<=len;j++){    //不用判断整体是否为回文串了 j=0就可以判断。
                if(isPal(s,j,i-1)){
                    minCut[i]=Math.min(minCut[j]+1,minCut[i]);
                }
            }
        }
        return minCut[len];
    }
}

