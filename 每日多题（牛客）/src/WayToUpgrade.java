import java.util.Scanner;
//小易的升级之路
public class WayToUpgrade {
    //辗转相除法求最大公约数
    private static int GCD(int x,int y){
        return x%y==0?y:GCD(y,x%y);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            int ability=sc.nextInt();
            int[] monster=new int[n];
            for(int i=0;i<n;i++){
                monster[i]=sc.nextInt();

                if(monster[i]<=ability)
                    ability+=monster[i];
                else
                    ability+=GCD(ability,monster[i]);
            }
            System.out.println(ability);
        }
    }
}
