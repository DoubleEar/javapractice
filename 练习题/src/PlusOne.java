import java.util.Arrays;

//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] a={9,9,9};
        System.out.println(Arrays.toString(plusOne(a)));
    }
}
