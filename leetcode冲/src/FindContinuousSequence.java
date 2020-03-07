import java.util.ArrayList;
import java.util.Arrays;

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
public class FindContinuousSequence {
    public static int[][] findContinuousSequence(int target) {
        /*
        假设有2个数的和等于target,设最小的那个数的值为n
        显然n+(n+1)=target,则n=(target-1)/2;如果没有2个数的和为target
        那么假设有3个，则有n+(n+1)+(n+2)=target,n=(target-1-2)/3;
         */
        ArrayList<int[]> list=new ArrayList<>();
        int i=1;//i用来表示序列长度
        while (target>0){
            target-=i;//先求出分母
            i++;//此时表示真正的序列长度
            if(target>0&&target%i==0){//判断target是否可以由i个连续相加的数组成
                int[] temp=new int[i];//申请i个长度的数组空间
                for(int start=target/i,j=0;start<target/i+i;start++,j++){
                    temp[j]=start;
                }
                list.add(temp);
            }
        }
        //根据题意返回的序列个数从小到大，所以要反转list
        int size=list.size();
        int[][] res=new int[size][];
        for(int j=size-1,k=0;j>=0;j--,k++){
            res[k]=list.get(j);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findContinuousSequence(9)));
    }
}
