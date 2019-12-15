//给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，
// 该数组能否变成一个非递减数列。

import java.util.ArrayList;
import java.util.List;

public class ChangeNumber {
    public boolean checkPossibility(int[] nums) {
        List<int[]> down = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int[] pair = new int[2];
                    pair[0] = nums[i];
                    pair[1] = nums[j];
                    down.add(pair);
                }
            }
        }

        boolean aSame = true;
        boolean bSame = true;
        int lastA = -1;
        int lastB = -1;
        for (int[] a : down) {
            if (lastA == -1) {
                lastA = a[0];
                lastB = a[1];
            } else {
                if (lastA != a[0]) {
                    aSame = false;
                }
                if (lastB != a[1]) {
                    bSame = false;
                }
                if (!aSame && !bSame) {
                    return false;
                }
            }
        }

        return true;
    }
}
