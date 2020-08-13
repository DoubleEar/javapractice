import java.util.Arrays;
//数组排序
public class Sort {
    /**
     * 数组排序
     * @param a int整型一维数组 数组a升序
     * @param b int整型一维数组 数组b降序
     * @return int整型一维数组
     */
    public static int[] sort (int[] a, int[] b) {
        int len1=a.length;
        int len2=b.length;

        int[] res=new int[len1+len2];

        int index=0;
        for(int i=0;i<a.length;i++){
            res[index++]=a[i];
        }
        for(int i=0;i<b.length;i++){
            res[index++]=b[i];
        }

        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[] a={7,8,9};
        int[] b={3,2,1};
        System.out.println(Arrays.toString(sort(a,b)));
    }
}
