import java.util.Scanner;
//统计相同成绩的同学个数
public class CountSameGrade {
    private static int countNumber(int[] res,int grade){
        int count=0;
        for(int i=0;i<res.length;i++){
            if(res[i]==grade)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();//输入的同学个数
            int[] res=new int[n];
            //收集同学的成绩
            for(int i=0;i<res.length;i++){
               res[i]=sc.nextInt();
            }
            int grade=sc.nextInt();//目标成绩
            System.out.println(countNumber(res,grade));
        }
    }
}
