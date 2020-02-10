//找出数组中重复的数
public class Find_Duplicate {
    public static int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        //兔子走两步，乌龟走一步。如果是环形，必定相遇
        slow=nums[slow];
        fast=nums[nums[fast]];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        //头到环点与相遇点到环点的距离相等
        //各走一步直到走到环点
        int pre1=0;
        int pre2=slow;
        while(pre1!=pre2){
            pre1=nums[pre1];
            pre2=nums[pre2];
        }
        return pre1;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,3};
        System.out.println(findDuplicate(nums));
    }
}
