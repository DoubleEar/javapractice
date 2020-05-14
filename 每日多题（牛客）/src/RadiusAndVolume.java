import java.util.Scanner;
//圆的半径与体积
public class RadiusAndVolume {
    private static void calculate(int x0,int y0,int z0,int x1,int y1,int z1){
        double res1=Math.pow(x1-x0,2);
        double res2=Math.pow(y1-y0,2);
        double res3=Math.pow(z1-z0,2);

        double r=Math.sqrt(res1+res2+res3);
        double v=(4*Math.acos(-1)*Math.pow(r,3))/3;

        System.out.printf("%.3f",r);
        System.out.print(" ");
        System.out.printf("%.3f",v);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int x0=sc.nextInt();
            int y0=sc.nextInt();
            int z0=sc.nextInt();
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int z1=sc.nextInt();

            calculate(x0,y0,z0,x1,y1,z1);
        }
    }
}
