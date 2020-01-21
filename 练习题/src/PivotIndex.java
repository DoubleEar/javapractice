//数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int leftsum=0;
        int rightsum=0;
        int flag=-1;
        for(int i=0;i<nums.length;i++){
            rightsum+=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            rightsum-=nums[i];
            if(leftsum==rightsum){
                flag=i;
                break;
            }else{
                leftsum+=nums[i];
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,4,5};
        int[] nums2={5,6,3,7,3,1};
        System.out.println(pivotIndex(nums1));
        System.out.println(pivotIndex(nums2));
    }
}
