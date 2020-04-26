import java.util.Scanner;
//最高分是多少
public class TheHighestScore {
    private static void operator(String s,int A,int B,int[] score){
        if(s.equals("Q")){  //查询最高分
            int begin=Math.min(A,B);
            int end=Math.max(A,B);
            int max=0;

            for(int i=begin-1;i<end;i++){
                if(score[i]>max)
                    max = score[i];
            }
            System.out.println(max);
        }else if(s.equals("U")){    //更新成绩
            score[A-1]=B;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int operate=sc.nextInt();

            int[] score=new int[n];
            for(int i=0;i<n;i++){
                score[i]=sc.nextInt();
            }

            String  c=null;
            int A=0;
            int B=0;
            for(int i=0;i<operate;i++){
                c=sc.next();
                A=sc.nextInt();
                B=sc.nextInt();

                operator(c,A,B,score);
            }
        }
    }
}
