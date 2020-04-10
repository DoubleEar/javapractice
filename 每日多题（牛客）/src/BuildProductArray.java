import java.util.Arrays;
//构建一个数组B，使得B[i]=A数组除了A[i]其他数的乘积。
public class BuildProductArray {
    public static int[] multiply(int[] A) {
        int len=A.length;
        int[] B=new int[len];
        /*
            解释下代码，设有数组大小为5。
            对于第一个for循环
            第一步：b[0] = 1;
            第二步：b[1] = b[0] * a[0] = a[0]
            第三步：b[2] = b[1] * a[1] = a[0] * a[1];
            第四步：b[3] = b[2] * a[2] = a[0] * a[1] * a[2];
            第五步：b[4] = b[3] * a[3] = a[0] * a[1] * a[2] * a[3];
         */
        if(len!=0) {
            B[0]=1;
            //B[i]=B[i-1]*A[i-1],此时除了最后一个元素，i之后的元素还没乘。
            for (int i = 1; i < len; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
        }
        /*
        temp *= a[4] = a[4];
        b[3] = b[3] * temp = a[0] * a[1] * a[2] * a[4];
        第二步
        temp *= a[3] = a[4] * a[3];
        b[2] = b[2] * temp = a[0] * a[1] * a[4] * a[3];
        第三步
        temp *= a[2] = a[4] * a[3] * a[2];
        b[1] = b[1] * temp = a[0] * a[4] * a[3] * a[2];
        第四步
        temp *= a[1] = a[4] * a[3] * a[2] * a[1];
        b[0] = b[0] * temp = a[4] * a[3] * a[2] * a[1];
         */
        int temp=1;
        for(int j=len-2;j>=0;j--){
            //B从倒数第二个数开始依次乘A[j+1]……A[len-1];
            temp*=A[j+1];
            B[j]*=temp;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A={1,2,3,4,5};
        System.out.println(Arrays.toString(multiply(A)));
    }
}
