import java.util.ArrayList;
//和为s的连续正数序列
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
public class FindContinuousSequence {
    public static int[][] findContinuousSequence(int target) {
        if(target<3)
            return null;
        ArrayList<int[]> res=new ArrayList<>();
        int i=1;    //代表滑动窗口的左边界
        int j=1;    //代表滑动窗口的右边界
        int sum=0;

        while (i<=target/2){    //序列中至少有两个数字。
            if(sum<target) {
                sum += j;   //向右滑动
                j++;        //指向右边界值得下一个位置
            }else if(sum>target){
                sum-=i;
                i++;
            }else {     //等于target时，记录当前的结果。
                int[] arr=new int[j-i];
                for(int k=i;k<j;k++){
                    arr[k-i]=k;
                }
                res.add(arr);
                sum-=i;  //左窗口继续向右滑动，寻找下一组的结果。
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        findContinuousSequence(9);
    }
}
