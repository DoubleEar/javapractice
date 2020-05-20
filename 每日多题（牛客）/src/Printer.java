import java.util.Arrays;

//二维数组打印
//按照从右上角到左下角的顺序打印二维数组
public class Printer {
    public static int[] arrayPrint(int[][] arr, int n) {
        //打印上三角包括中间[0,0]-[n,n]的对角线
        int[] res=new int[n*n];
        int index=0;
        for(int i=n-1;i>=0;i--){
            int temp=i;
            for(int j=0;j<n-i;j++){
                res[index++]=arr[j][temp++];
            }
        }

        //打印剩下的下三角
        for(int i=1;i<n;i++){
            int k=i;
            for(int j=0;j<n-i;j++){
                res[index++]=arr[k++][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(Arrays.toString(arrayPrint(arr, 4)));
    }
}
