import java.util.LinkedList;
import java.util.Queue;
//腐烂的橘子
class pair{
    public int x;
    public int y;

    public pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class OrangesRotting {
    /*
      在给定的网格中，每个单元格可以有以下三个值之一：
	  值 0 代表空单元格 值 1 代表新鲜橘子 值 2 代表腐烂的橘子
      每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
      返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。
      如果不可能，返回 -1。
     */
    public static int orangesRotting(int[][] grid) {
        Queue<pair> queue=new LinkedList<>();
        int row=grid.length;
        int col=grid[0].length;

        for(int i=0;i<row;i++){ //先将所有的腐烂的橘子加入队列
            for(int j=0;j<col;j++){
                if(grid[i][j]==2)
                    queue.offer(new pair(i,j));
            }
        }

        int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};  //上下左右
        int step=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            boolean flag=false;

            while (size--!=0){
                pair curOrange=queue.poll();
                for(int i=0;i<4;i++){   //判定四个方向的橘子被腐烂的情况
                    int newX=curOrange.x+direction[i][0];
                    int newY=curOrange.y+direction[i][1];

                    if(newX<0||newX>=row||newY<0||newY>=col||grid[newX][newY]!=1)
                        continue;

                    flag=true;
                    grid[newX][newY]=2;
                    queue.offer(new pair(newX,newY));
                }
            }
            if(flag)    //只有被腐烂才能算一个step
                step++;
        }

        for(int i=0;i<row;i++){     //判断剩下的橘子中是否还有好的橘子
            for(int j=0;j<col;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[][] grid={{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
