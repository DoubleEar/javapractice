import java.util.Scanner;
//将n张牌放入n个不同的盒子里，一个盒子只能放一张牌。
public class PutCards {
    public static void DFS(int[] box,int[] visited,int index,int n){
        if(index==n+1){
            for(int i=1;i<=n;i++){
                System.out.print(box[i]+" ");
            }
            System.out.println();
            return;     //回退
        }

        for(int i=1;i<=n;i++){
            if(visited[i]==0){  //第i号牌在手中
                box[index]=i;
                visited[i]=1;   //第i号牌已经被用了

                DFS(box,visited,index+1,n); //处理下一个盒子

                visited[i]=0;   //下一个盒子回退到当前盒子时，收牌。
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] box=new int[n+1];
        int[] visited=new int[n+1]; //用来标记第i张牌是否在手中

        DFS(box,visited,1,n);
    }
}
