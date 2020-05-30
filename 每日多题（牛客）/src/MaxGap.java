import java.util.Arrays;
//左右最值最大差
public class MaxGap {
    /*
        给定一个长度为N(N>1)的整型数组A，可以将A划分成左右两个部分，
        左部分A[0..K]，右部分A[K+1..N-1]，K可以取值的范围是[0,N-2]。
        求这么多划分方案中，左部分中的最大值减去右部分最大值的绝对值，最大值。
     */
    public static int findMaxGap(int[] A, int n) {
        if(n==0)
            return 0;
        if(n==1)
            return A[0];
        if(n==2)
            return Math.abs(A[0]-A[1]);

        int borderLine=n-2;
        int maxL,maxR,max=0;

        for(int i=0;i<=borderLine;i++){     //左边的所有情况
            int[] temp1=Arrays.copyOf(A,i+1);
            Arrays.sort(temp1);
            maxL=temp1[i];  //经过排序取到最大值

            //对应的右边的情况
            int[] temp2=Arrays.copyOfRange(A,i+1,n);
            Arrays.sort(temp2);
            maxR=temp2[temp2.length-1]; //经过排序取到最大值

            int res=Math.abs(maxL-maxR);

            if(res>max)
                max=res;

        }
        return max;
    }

    public static void main(String[] args) {
        int[] A={28,75,38,44,66,1};
        System.out.println(findMaxGap(A, 6));
    }
}
