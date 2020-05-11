import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//顺时针打印矩阵
public class SpiralOrder {
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix==null)
            return null;
        List<Integer> list=new ArrayList<>();
        int rows=matrix.length;

        if(rows<=0){
            return new int[0];
        }

        int cols=matrix[0].length;
        int n=rows*cols;
        int[] res=new int[n];

        int start=0;
        //一圈一圈打印，每次开始的位置都是行列相同的地方如：[0,0][1,1][2,2]。
        while (rows>start*2&&cols>start*2){
            printMatrixInCircle(matrix,rows,cols,start,list);
            start++;
        }

        for(int i=0;i<n;i++){
            res[i]=list.get(i);
        }

        return res;
    }

    private static List<Integer> printMatrixInCircle(int[][] matrix, int rows, int cols,int start,List<Integer> list) {
        int endX=cols-1-start;  //终止列号
        int endY=rows-1-start;  //终止行号

        //从左到右打印一行
        for(int i=start;i<=endX;i++){
            list.add(matrix[start][i]);
        }

        //从上往下打印一列
        if(start<endY){
            for(int i=start+1;i<=endY;i++){
                list.add(matrix[i][endX]);
            }
        }

        //从右往左打印一行
        if(start<endX&&start<endY){
            for(int i=endX-1;i>=start;i--){
                list.add(matrix[endY][i]);
            }
        }

        //从下往上打印一行
        if(start<endX&&start<endY-1){
            for(int i=endY-1;i>=start+1;i--){
                list.add(matrix[i][start]);
            }
        }
        return list;
    }

    /*
        public int[] spiralOrder(int[][] matrix) {
            if(matrix.length == 0) return new int[0];
            //l左边界，r右边界，t上边界，b下边界。
            int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
            int[] res = new int[(r + 1) * (b + 1)];
            while(true) {
                for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
                if(++t > b) break;
                for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
                if(l > --r) break;
                for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
                if(t > --b) break;
                for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
                if(++l > r) break;
        }
        return res;
    }
     */

    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }
}
