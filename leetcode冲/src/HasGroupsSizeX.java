//你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
//每组都有 X 张牌。
//组内所有的牌上都写着相同的整数。
public class HasGroupsSizeX {
    public static boolean hasGroupsSizeX(int[] deck) {
        // 计数
        int[] counter = new int[10000];
        for (int num: deck) {
            counter[num]++;
        }
        // 迭代求多个数的最大公约数
        int x = 0;
        for(int cnt: counter) {
            if (cnt > 0) {
                x = gcd(x, cnt);
                if (x == 1) { // 如果某步中gcd是1，直接返回false
                    return false;
                }
            }
        }
        return x >= 2;
    }

    // 辗转相除法,求最大公约数
    private static int gcd (int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }
    public static void main(String[] args) {
        int[] deck = new int[]{0, 0, 1, 1, 1, 1, 2, 2, 4, 4};
        System.out.println(hasGroupsSizeX(deck));
    }
}
