import java.util.Scanner;
//组个最小数
//输入十个数，分别代表有多少个0~9。
public class CombinedDecimal {
    private static String combinedDecimal(int[] n){
        int count=0;
        //计算一共有几位数
        for(int i=0;i<n.length;i++){
            count+=n[i];
        }

        int[] arr=new int[count];
        int index=0;
        //将数按顺序放好
        for(int i=0;i<n.length;i++){
            for(int j=0;j<n[i];j++){
                arr[index++]=i;
            }
        }

        int flag = 0;//纪录第一个不为0的下标
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                flag=i;
                sb.append(arr[i]);//先拼接到sb中
                break;
            }
        }

        for(int i=0;i<arr.length;i++){
            if(i!=flag){
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] n = new int[10];
        for(int i = 0;i <n.length;i++){
            n[i] = sc.nextInt();
        }
        System.out.println(combinedDecimal(n));
    }
}
