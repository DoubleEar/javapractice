import java.util.Scanner;
//计算日期到天数转换
public class DaysConversion {
    private static int conversion(int year,int month,int day){
        int[] days={31,29,31,30,31,30,31,31,30,31,30,31};

        if(year<=0||month<=0||month>12||day<=0||day>days[month-1]){
            return -1;
        }

        //先判断是否为闰年
        if(year%4==0&&year%100!=0||year%400==0){

        }else{  //不是闰年
            days[1]=28;
        }

        int sum=0;
        for(int i=0;i<month-1;i++){
            sum+=days[i];
        }
        return sum+day;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int year=sc.nextInt();
            int month=sc.nextInt();
            int day=sc.nextInt();

            System.out.println(conversion(year, month, day));
        }
    }
}
