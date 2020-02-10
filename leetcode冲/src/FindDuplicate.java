//找出重复的数
public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        int left=1;
        int right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2;

            int count=0;
            for(int num:nums){
                if(num<=mid){
                    count++;
                }
            }

            if(count>mid){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,3};
        System.out.println(findDuplicate(nums));
    }
}
