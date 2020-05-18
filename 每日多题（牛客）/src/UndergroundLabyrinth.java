import java.util.Scanner;
//地下迷宫
public class UndergroundLabyrinth {
    //从（0，0）到目标点（0，m-1）。二维数组中是1可以走，是0不能走。
    static String path="";  //用来统计走过的路径
    private static String labyrinth(int n,int m,int[][] puzzle,int power){
        boolean[][] visited=new boolean[n][m];  //标记二维数组

        findWay(n,m,"",0,0,puzzle,power,visited);

        return path;
    }

    private static void findWay(int n,int m,String res,int x,int y,int[][] puzzle,int power,boolean[][] visited){
        if(power<0){
            path = "Can not escape!";
            return;
        }else if(x==0&&y==m-1&&puzzle[0][m-1]==1){  //走到目标点且能量值>=0
            path=res+"[0," + (m - 1) + "]";
            return;
        }

        //当走的格子合法并且当前坐标是1，还未被访问过。
        if(x<n&&y<m&&x>=0&&y>=0&&puzzle[x][y]==1&&!visited[x][y]){
            visited[x][y]=true;

            res+="["+x+","+y+"],";

            /*
                注：因为目标点是（0，m-1）所以先水平向右走。
                后面根据power消耗值小的走。
             */
            //水平向右
            findWay(n,m,res,x,y+1,puzzle,power-1,visited);
            //向下
            findWay(n,m,res,x+1,y,puzzle,power,visited);
            //水平向左
            findWay(n,m,res,x,y-1,puzzle,power-1,visited);
            //向上
            findWay(n,m,res,x-1,y,puzzle,power-3,visited);
        }

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int power=sc.nextInt();
            int[][] puzzle=new int[n][m];
            //迷宫是一个n*m的二维数组
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    puzzle[i][j]=sc.nextInt();
                }
            }
            System.out.println(labyrinth(n,m,puzzle,power));
        }
    }
}
