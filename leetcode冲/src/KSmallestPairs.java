import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

//给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
//找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)
public class KSmallestPairs {
    private static int twoSum(int[] arr) {
        return arr[0] + arr[1];
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> resList = new LinkedList<>();
        //优先队列，使前k对数据降序排列，维持一个大根堆。
        PriorityQueue<int[]> pQ = new PriorityQueue<>((e1, e2) -> twoSum(e2)-twoSum(e1));

        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int[] arr = new int[]{n1, n2};
                //将n1，n2加到优先队列中，将他们的和降序排列。（自定义比较器）
                pQ.add(arr);
                //大根堆中存放前k对元素，不断删除堆顶元素。
                if (pQ.size() > k)
                    pQ.poll();
            }
        }

        //此时队列中只剩余k对数字，当队列不为空时出队。
        while (!pQ.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int[] arr = pQ.poll();
            //将一对数字，增加到list中。
            list.add(arr[0]);
            list.add(arr[1]);
            //将此对数字，增加到二维list中，以完成返回。
            resList.add(list);
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] num1={1,7,11};
        int[] num2={2,4,6};
        System.out.println(kSmallestPairs(num1,num2,3));
    }
}
