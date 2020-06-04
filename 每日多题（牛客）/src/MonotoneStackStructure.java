import java.util.Scanner;
import java.util.Stack;
//单调栈结构
public class MonotoneStackStructure {
    private static int[][] monotoneStack(int[] nums,int n){
        Stack<Integer> stack=new Stack<>();
        int[][] res=new int[n][2];  //第一列记录符合条件的left下标 第二列记录符合条件的right下标
        for(int i=0;i<n;i++){
            //当栈不为空且栈顶元素大于当前值（不符合单调栈的规则）
            while (!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                int popIndex=stack.pop();   //栈顶元素出栈
                int left=stack.isEmpty()?-1:stack.peek();   //判断有没有符合的left
                res[popIndex][0]=left;  //更新
                res[popIndex][1]=i;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){   //如果栈不为空
            int popIndex=stack.pop();
            int left=stack.isEmpty()?-1:stack.peek();
            res[popIndex][0]=left;
            res[popIndex][1]=-1;    //此时不会再有符合条件的right。
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] nums=new int[n];

            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }

            int[][] res= monotoneStack(nums,n);
            for(int i=0;i<res.length;i++){
                System.out.println(res[i][0]+" "+res[i][1]);
            }
        }
    }
}
