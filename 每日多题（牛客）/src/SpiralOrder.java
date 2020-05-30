import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//顺时针打印矩阵
public class SpiralOrder {
    public static int[] clockwisePrint(int[][] mat, int n, int m) {
        if(mat==null)   //矩阵为空
            return null;
        List<Integer> list=new ArrayList<>();

        if(n<=0)    //矩阵没有元素
            return new int[0];

        int[] res=new int[n*m];

        int start=0;

        //一圈一圈打印，每次开始的位置都是行列相同的地方如：[0,0][1,1][2,2]。
        while (n>start*2&&m>start*2){
            printMatInCircle(mat,n,m,start,list);
            start++;
        }

        for(int i=0;i<n*m;i++){
            res[i]=list.get(i);
        }

        return res;
    }

    private static List<Integer> printMatInCircle(int[][] mat,int n,int m,int start,List<Integer> list){
        int endX=m-start-1; //终止列号
        int endY=n-start-1; //终止行号

        //从左往右打印一行
        for(int i=start;i<=endX;i++){
            list.add(mat[start][i]);
        }

        //从上往下打印一列
        if(start<endY) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(mat[i][endX]);
            }
        }

        //从右往左打印一行
        if(start<endX&&start<endY) {
            for (int i = endX - 1; i >= start; i--) {
                list.add(mat[endY][i]);
            }
        }

        //从下往上打印一列
        if(start<endX&&start<endY-1) {  //想两行两列的例子
            for (int i = endY - 1; i >= start+1; i--) {  //start+1-->边界已经被打印了
                list.add(mat[i][start]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(clockwisePrint(mat, 3, 3)));
    }
}
