import java.util.Scanner;
//进制转换
public class NumberBaseConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            StringBuffer sb = new StringBuffer();
            sb.append(sc.nextLine());
            //从最低位开始算，所以要反转，之后去掉0x。
            String s = sb.reverse().substring(0, sb.length() - 2);
            char[] c = s.toCharArray();
            int sum = 0;
            for (int i = 0; i < c.length; i++) {
                if (c[i] >= 'A' && c[i] <= 'F') {
                    //十六进制 A^F -> 10~15
                    sum += (Integer.valueOf(c[i]) - 55) * Math.pow(16, i);
                } else {
                    //48->'0'  减去0的ASCII值
                    sum += (Integer.valueOf(c[i]) - '0') * Math.pow(16, i);
                }
            }
            System.out.println(sum);
        }
    }
}
