import java.util.Arrays;
//给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数
// 如果这个数组是 [a1, a2, a3, ... , an] ，
// 那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；
public class ConstructArray {
    public static int[] constructArray(int n, int k) {
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=i+1;
        }
        if(k==1)
            return res;
        for(int m=1;m<k;m++){
            reverse(res,m,n-1);
        }
        return res;
    }

    private static void reverse(int[] res,int i,int j) {
        while(i<j){
            int t=res[i];
            res[i]=res[j];
            res[j]=t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(5,2)));
    }
}
