import java.util.Arrays;

//给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数
// 如果这个数组是 [a1, a2, a3, ... , an] ，
// 那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；
public class Construct_Array {
    public static int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int l = 1, r = n;
        // 前 k 个数需要间隔从两端取；
        int i = 0;
        while (true) {
            if (i < k) {
                res[i] = l;
                i++;
                l++;
            } else {
                break;
            }
            if (i < k) {
                res[i] = r;
                i++;
                r--;
            } else {
                break;
            }
        }
        // 剩下的数字则按照降序或者升序排列；
        if (k % 2 == 1) {
            for (int j = k; j < res.length; j++) {
                res[j] = l;
                l++;
            }
        } else {
            for (int j = k; j < res.length; j++) {
                res[j] = r;
                r--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(5,2)));
    }
}
