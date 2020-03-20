import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//给定两个数组，编写一个函数来计算它们的交集。
public class Intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        /*
        //两个set
        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();

        for(int nums:nums1){
            s1.add(nums);
        }

        for(int nums:nums2){
            if(s1.contains(nums))
                s2.add(nums);
        }

        int[] res=new int[s2.size()];
        int i=0;
        for(int value:s2){
            res[i++]=value;
        }
        return res;
        */

        //一个set双指针
        Set<Integer> set=new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]<nums2[j])
                i++;
            else if(nums2[j]<nums1[i])
                j++;
        }
        int[] res=new int[set.size()];
        int index=0;
        for(int nums:set){
            res[index++]=nums;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1={1,4,3,9};
        int[] nums2={8,9,4};
        System.out.println(Arrays.toString(intersection(num1,nums2)));
    }
}
