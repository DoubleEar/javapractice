import java.util.Scanner;
//两个格子之间欧几里得距离为2的不可以放置蛋糕，求能放蛋糕的个数。
/*
1 1 X X 1 1    每四行四列都为这样的一个周期
1 1 X X 1 1    如果行或列能被4整除，就能放置一半的蛋糕
X X 1 1 X X    如果不能被4整除就一半多一个蛋糕。
X X 1 1 X X
 */
public class ThrowTwo {
    private static int Count(int row,int col){
        int count=0;
       if(row%4==0||col%4==0){
           count=(row*col)/2;
       }else{
           count=(row*col)/2+1;
       }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        int res=Count(row,col);
        System.out.println(res);
    }
}
