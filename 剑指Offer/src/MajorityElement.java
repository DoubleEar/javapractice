//数组中出现次数超过一半的数字
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        //数组中出现次数超过一半的数字肯定比其他数字的和加起来还要多
        int len=nums.length;
        int result=nums[0];
        int count=1;
        for(int i=1;i<len;i++){
            if(count==0){
                result=nums[i];
                count=1;
            }else if(result==nums[i])
                count++;
            else
                count--;
        }

        count=0;
        for(int i=0;i<len;i++){
            if(nums[i]==result)
                count++;
        }
        return count>len/2?result:0;
    }

    public static void main(String[] args) {
        int[] res={1,2,3,4,5,6,7};
        System.out.println(majorityElement(res));
    }
}
