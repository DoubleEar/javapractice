import java.util.*;
//火车进站->合理的出栈序列
public class ArrivalTrain {
    private static List<int[]> list = new ArrayList<>();//存放所有可能的出栈序列(不一定合法)
    private static List<String> res = new ArrayList<>();//存放最终所有合法的出栈序列

    //求解所有可能的出栈序列(不一定合法)->全排列
    private static void permutations(int n,int[] in,int index){
        //此时只剩下一个元素，不用再交换了，并将此时所得数组存入集合list中
        if(index==n-1){
            int[] res=in.clone();
            list.add(res);
            return;
        }

        for(int i=index;i<in.length;i++){
            swap(in,i,index);
            permutations(n,in,index+1);
            swap(in,i,index);
        }
    }

    private static void swap(int[] in,int i,int j){
        int temp=in[i];
        in[i]=in[j];
        in[j]=temp;
    }

    //判断出栈序列是否合法
    //将进站序列依次压入栈中
    // 如果栈顶元素和出站序列元素相同那么栈顶元素出栈，同时出栈序列向后走一步，继续比较；
    // 如果不相同，那么继续进站序列入栈
    //直到进站序列元素全部压入栈中。
    //最后如果栈为空，说明出栈序列合法；否则，出栈序列就是不合法的
    private static boolean isLegal(int[] in,int[] out,int n){
        Stack<Integer> stack = new Stack<>();
        if (in.length == 0 || out.length == 0 || in.length != out.length) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < in.length; i++) {
            stack.push(in[i]);

            while (j<n&&!stack.isEmpty() && stack.peek() == out[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    //数组变成字符串，方便最后结果按字典序进行排序
    private static String myToString(int[] out,int n){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(out[i]);
            if(i!=n-1)
                sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            int[] in=new int[n];
            for(int i=0;i<in.length;i++){
                in[i]=sc.nextInt();
            }

            //先将输入的序列进行全排列
            permutations(n,in,0);

            //遍历所有的序列
            for(int[] out:list){
                if(isLegal(in,out,n)){//判断是否合法
                    String s=myToString(out,n);//将数组转化为字符串
                    res.add(s);//保存到结果中
                }
            }

            Collections.sort(res);//将所有符合的结果按字典序排列

            for (String s : res) {//输出
                System.out.println(s);
            }
        }
    }
}
