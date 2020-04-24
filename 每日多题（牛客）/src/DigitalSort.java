import java.text.DecimalFormat;
import java.util.Scanner;
//数字分类
public class DigitalSort {
    /*
    private static void sort(int[] arr,int n){
        //能被5整除所有偶数之和
        int sum=0;
        for(int i:arr){
            if(i%n==0&&i%2==0){
                sum+=i;
            }
        }
        if(sum==0) {
            System.out.print("N" + " ");
        }else{
            System.out.print(sum + " ");
        }

        //将被5除后余1的数字按给出顺序进行交错求和
        int[] res=new int[arr.length];
        int index=0,flag=0;
        for(int i:arr){
            if(i%n==1){
                res[index++]=i;
                flag++;
            }
        }
        sum=0;
        for(int i=0;i<flag;i++){
            if(i%2==0){
                sum+=res[i];
            }else if(i%2!=0){
                sum-=res[i];
            }
        }
        if(sum==0) {
            System.out.print("N" + " ");
        }else{
            System.out.print(sum + " ");
        }

        //被5除后余2的数字的个数
        sum=0;
        for(int i:arr){
            if(i%n==2){
              sum++;
            }
        }
        if(sum==0) {
            System.out.print("N" + " ");
        }else{
            System.out.print(sum + " ");
        }

        //被5除后余3的数字的平均数
        flag=0;
        float a=0;
        for(int i:arr){
            if(i%5==3){
                flag++;
                a+=i;
            }
        }

        if(a==0) {
            System.out.print("N" + " ");
        }else {
            DecimalFormat df = new DecimalFormat("#.0");
            System.out.print(df.format(a / flag) + " ");
        }

        //被5除后余4的最大数
        int max=0;
        for(int i:arr){
            if(i%5==4){
                if(i>max)
                    max=i;
            }
        }
        if(max==0) {
            System.out.print("N" + " ");
        }else {
            System.out.print(max);
        }
    }
    */

    private static void sort(int[] arr){
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int temp = 1;
        boolean find2 = false;
        int sum4 = 0;
        int count4 = 0;
        int a5 = 0;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]%5){
                case 0:
                    if (arr[i]%2==0){
                        a1+=arr[i];
                    }
                    break;
                case 1:
                    find2 = true;
                    a2 += temp*arr[i];
                    temp = (-1)*temp;
                    break;
                case 2:
                    a3++;
                    break;
                case 3:
                    sum4 += arr[i];
                    count4++;
                    break;
                case 4:
                    if (a5 < arr[i]){
                        a5 = arr[i];
                    }
                    break;
                default:
                    break;
            }
        }
        String A4 = "N";
        if (count4>0){
            A4 = new DecimalFormat("0.0").format(sum4*1.0 / count4);
        }

        if (a1 == 0){
            System.out.print("N"+" ");
        }else {
            System.out.print(a1+" ");
        }
        if (find2){
            System.out.print(a2+" ");
        }else {
            System.out.print("N"+" ");
        }
        if (a3 == 0){
            System.out.print("N"+" ");
        }else {
            System.out.print(a3+" ");
        }
        System.out.print(A4+" ");
        if (a5 == 0){
            System.out.print("N");
        }else {
            System.out.print(a5);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            sort(arr);
        }
    }
}
