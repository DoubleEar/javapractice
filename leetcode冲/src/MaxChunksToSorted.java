//数组arr是[0, 1, ..., arr.length - 1]的一种排列。（已知数组是连续的）
// 我们将这个数组分割成几个“块”，并将这些块分别进行排序。
// 之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
public class MaxChunksToSorted {
    public static int maxChunksToSorted(int[] arr) {
        //能分成块的前提是，每个块中元素是连续的，且前面块最大值要小于后面块的最大值
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length;i++) {
            max = Math.max(max, arr[i]);
            //检验前k个元素中的最大值是否为k，如果是它们就可以被分成一个块
            if (max == i)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={1,0,4,3,2};
        System.out.println(maxChunksToSorted(arr));
    }
}
