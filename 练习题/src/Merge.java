import java.util.Arrays;

//给定两个有序整数数组 nums1 和 nums2，
// 将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //固定数组nums1的最后一个位置
        int pos = m + n - 1;
        //固定数组nums1元素的最后一个位置
        int s1 = m - 1;
        //固定数组nums2元素的最后一个位置
        int s2 = n - 1;
        while (s1 >= 0 && s2 >= 0) {
            //当数组nums1下标s1大于等于数组nums2时
            if (nums1[s1] >= nums2[s2]) {
            //将数组nums1下标s1的值赋给数组nums1下标pos
            //并将位置往前移动一位
                nums1[pos--] = nums1[s1--];
            } else {
                nums1[pos--] = nums2[s2--];
            }
        }
        while (s1 >= 0) {
            nums1[pos--] = nums1[s1--];
        }
        while (s2 >= 0) {
            nums1[pos--] = nums2[s2--];
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,8,0,0,0};
        int[] nums2={3,8,9};
        merge(nums1,4,nums2,3);
    }
}
