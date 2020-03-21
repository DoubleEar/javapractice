import java.util.*;

//给定两个数组，编写一个函数来计算它们的交集。
//输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
public class Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map1=new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        for(int n:nums1){
            map1.put(n,map1.getOrDefault(n,0)+1);
        }

        for(int m:nums2){
            //如果map中有m且个数大于0
            if (map1.containsKey(m) && map1.get(m)>0) {
                list.add(m);
                //将m的值减1
                map1.put(m,map1.get(m)-1);
            }
        }

        int[] res=new int[list.size()];
        int index=0;
        for(int nums:list){
            res[index++]=nums;
        }
        return res;

        /*
        LinkedList<Integer> list=new LinkedList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]<nums2[j])
                i++;
            else if(nums2[j]<nums1[i])
                j++;
        }
        int[] res=new int[list.size()];
        int index=0;
        for(int nums:list){
            res[index++]=nums;
        }
        return res;
        */
    }

    public static void main(String[] args) {
        int[] nums1={1,2,2,4};
        int[] nums2={2,2};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }
}
