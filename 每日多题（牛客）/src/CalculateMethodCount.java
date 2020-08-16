//老板发奖金
public class CalculateMethodCount {
    /**
     * 发奖金，老板可以1元、2元……n元发，问n元能有多少种发法
     * @param num_money int整型 奖金的总数,单位为元
     * @return int整型
     */
    public static int CalculateMethodCount (int num_money) {
        if(num_money<=0)
            return 0;
        int res=(int) Math.pow(2,num_money-1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(CalculateMethodCount(3));
    }
}
