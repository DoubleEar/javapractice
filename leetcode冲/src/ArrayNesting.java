// 找到并返回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
public class ArrayNesting {
    public static int arrayNesting(int[] nums) {
       //创建一个布尔类型的数组，确保所有元素只用考虑一次
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            //当元素没有被标记过时进入循环
            if (!visited[i]) {
                int start = nums[i], count = 0;

                do {
                    start = nums[start];
                    count++;
                    //将索引元素标记
                    visited[start] = true;
                }
                while (start != nums[i]);

                res = Math.max(res, count);
            }
        }
        return res;

        /*int result = 0;
        for(int i=0;i<nums.length;i++){
            int count=0, k=i;
            while(nums[k]!=-1){
                count++;
                int tmp = nums[k];
                nums[k] = -1;
                k = tmp;
            }
            result = Math.max(result,count);
        }
        return result;
        */
    }

    public static void main(String[] args) {
        int[] nums={5,4,0,3,1,6,2};
        System.out.println(arrayNesting(nums));
    }
}
