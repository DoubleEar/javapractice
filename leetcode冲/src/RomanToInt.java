//罗马数字转整数
public class RomanToInt {
    public static int romanToInt(String s) {
        int sum=0;
        //前一个数字
        int preNum=getValue(s.charAt(0));
        for(int i=1;i<s.length();i++){
            int num=getValue(s.charAt(i));
            //如果前一个数字小于当前数字，证明当前数字-前一个数字为他们组合的值
            if(preNum<num){
                sum-=preNum;
            }else {
                sum+=preNum;
            }
            //前一个数字进行更新
            preNum=num;
        }
        //将最后一个数字加进sum中
        sum+=preNum;
        return sum;
    }

    private static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String s="XLVI";
        System.out.println(romanToInt(s));
    }
}
