public class MinArray {
    //顺序查找
    private static int MinInOrder(int[] nums,int left,int right){
        int res=nums[left];
        for(int i=left+1;i<=right;i++){
            if(res>nums[i])
                res=nums[i];
        }
        return res;
    }

    public static int minArray(int[] numbers) {
        if(numbers.length==1){
            return numbers[0];
        }
        int len=numbers.length;
        int left=0; //表示第一个递增数组的开头~末尾
        int right=len-1;   //表示第二个递增数组的开头~末尾
        /*
        将前面的0个元素旋转，到后面，就是数组本身。数组本身也是有序的。
        所以将mid的初始值设置为left。用于直接返回。
         */
        int mid=left;
        //前面的数大于后面的数，意味着发生了旋转，进入循环。
        while (numbers[left]>=numbers[right]){
            //当left指向第一个递增子数组的最后一个
            //right指向第二个递增子数组的第一个（相邻）
            //返回right所在下标的元素
            if(right-left==1)
                return numbers[right];
            mid=(left+right)/2;
            //如果left，right，mid所在下标的元素值相同。只能进行顺序查找。
            if(numbers[left]==numbers[mid]&&numbers[mid]==numbers[right]){
                return MinInOrder(numbers,left,right);
            }
            //如果中间的数大于等于左边的数，证明中间数在第一个递增子数组中。
            if(numbers[mid]>=numbers[left])
                left=mid;
            //如果中间的数小于等于左边的数，证明中间数在第二个递增子数组中。
            else if(numbers[mid]<=numbers[left])
                right=mid;
        }
        return numbers[mid];
    }

    public static void main(String[] args) {
        int[] nums={3,3,1,3};
        System.out.println(minArray(nums));
    }
}
