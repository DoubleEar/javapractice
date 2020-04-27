import java.util.Scanner;
//学分绩点
public class CountGPA {
    private static void countGPA(int n,int[] credit,int[] score,int sumCredit){
        double res=0;
        for(int i=0;i<n;i++){
            res+=(getGPA(score[i])*credit[i]);
        }
        System.out.printf("%.2f",res/sumCredit);
    }

    /*
     90——100 4.0 85——89 3.7 82——84 3.3
     78——81 3.0 75——77 2.7 72——74 2.3
     68——71 2.0 64——67 1.5 60——63 1.0 60以下 0
    */
    private static double getGPA(int n){
        if(n>=90)
            return 4.0;
        else if(n>=85)
            return 3.7;
        else if(n>=82)
            return 3.3;
        else if(n>=78)
            return 3.0;
        else if(n>=75)
            return 2.7;
        else if(n>=72)
            return 2.3;
        else if(n>=68)
            return 2.0;
        else if(n>=64)
            return 1.5;
        else if(n>=60)
            return 1.0;
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            int[] credit=new int[n];
            int[] score=new int[n];
            int sumCredit=0;
            for(int i=0;i<n;i++){
                credit[i]=sc.nextInt();
                sumCredit+=credit[i];
            }

            for(int i=0;i<n;i++){
                score[i]=sc.nextInt();
            }

            countGPA(n,credit,score,sumCredit);
        }
    }
}
