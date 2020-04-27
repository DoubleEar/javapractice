import java.util.Scanner;
//人民币转换
public class RMBConversion {
    static String[] map = {"壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    private static void conversion(String s){
        StringBuilder sb=new StringBuilder("人民币");
        String[] str=s.split("\\.");
        int number = Integer.valueOf(s.split("\\.")[0]);
        //处理亿
        int yi=(int)(number/10000_0000);
        if(yi!=0){
            sb.append(unitDivision(yi)).append("亿");
            number-=yi*10000_0000;
        }

        //处理万
        int wan=(int)(number/10000);
        if(wan!=0){
            sb.append(unitDivision(wan)).append("万");
            number-=wan*10000;
        }

        //处理千
        String res=unitDivision(number);
        if(res.length()>1){
            sb.append(res).append("元");
        }

        //若有小数点，处理效数点后面的数
        if(str.length>1){
            String point=str[1];
            sb.append(handlePoint(point));
        }

        String sbString = sb.toString();

        //当千位百位十位都为零时 会返回零 但是最高位不能为零
        if(sbString.length()>4 && sbString.charAt(3)=='零' && sbString.charAt(4)!='元'){
            //如果人民币的后一个字为“零”分割字符串去掉零。
            sbString = sbString.substring(0,3)+sbString.substring(4);
        }


        System.out.println(sbString);
    }

    private static String unitDivision(double n){
        StringBuilder sb=new StringBuilder();

        //千位
        int thousand=(int)(n/1000);
        if(thousand!=0){
            sb.append(map[thousand-1]).append("仟");
            n-=1000*thousand;
        }

        //百位
        int hundred=(int)(n/100);
        if(hundred!=0){
            sb.append(map[hundred-1]).append("佰");
            n-=100*hundred;
        }

        //零 只会出现在十位和百位
        if(thousand!=0&&hundred==0){
            sb.append("零");
        }

        //十位
        int decade=(int)(n/10);
        if(decade!=0){
            if(decade!=1) {
                sb.append(map[decade - 1]);
            }
            sb.append("拾");
            n-=10*decade;
        }

        //零 只会出现在十位和百位
        if(hundred!=0&&decade==0){
            sb.append("零");
        }

        //个位
        int unit=(int)(n%10);
        if(unit!=0){
            //5,0001 这种情况，千百十位均为0。
            if(thousand==0&&hundred==0&&decade==0)
                sb.append("零");
            sb.append(map[unit-1]);
        }

        return sb.toString();
    }

    //处理小数后面的数
    public static String handlePoint(String s){
        String res="";
        if(s.equals("0")||s.equals("00"))
            res="整";
        else{
            if(s.charAt(0)!='0'){
                res+=map[Integer.valueOf(s.charAt(0)+"")-1]+"角";
            }
            if(s.length()>1&&s.charAt(1)!='0'){
                res+=map[Integer.valueOf(s.charAt(1)+"")-1]+"分";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String n=sc.nextLine();
            conversion(n);
        }
    }
}
