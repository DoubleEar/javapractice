//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
public class Rotate {
    public void rotate(int[] nums, int k) {
        if(k==0||nums.length<2){
            return;
        }else{

            int[] b=new int[nums.length];
            if(k>nums.length)
                k%=nums.length;
            for(int i=0;i<nums.length-k;i++){
                b[i+k]=nums[i];
            }
            for(int i=nums.length-k;i<nums.length;i++){
                b[i+k-nums.length]=nums[i];
            }

            for(int i = 0;i<b.length;i++)
            {
                nums[i] = b[i];
            }

        }
    }
}
