//图像渲染
//给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）
// 和一个新的颜色值 newColor，让你重新上色这幅图像。
//只要是从初始点开始从四个正方向能遍历到的点
//（遍历到的点也可以继续从自己的四个正方向遍历）
// 并且颜色相同都要被染成新的颜色。
public class FloodFill {
    static int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
    private static void DFS(int[][] image,int[][] visited,int x,int y,int oldColor,int newColor,int row,int col){
        visited[x][y]=newColor;

        for(int i=0;i<4;i++){
            int newX=x+direction[i][0];
            int newY=y+direction[i][1];

            if(newX<0||newX>=row||newY<0||newY>=col)
                continue;

            if(image[newX][newY]==oldColor&&visited[newX][newY]==0)
                DFS(image,visited,newX,newY,oldColor,newColor,row,col);
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor=image[sr][sc];
        int row=image.length;
        int col=image[0].length;
        int[][] visited=new int[row][col];  //标记二维数组，避免newColor=oldColor这种情况发生。

        DFS(image,visited,sr,sc,oldColor,newColor,row,col);

        return image;
    }

    public static void main(String[] args) {
        int[][] image={{1,1,1},
                       {1,1,0},
                       {1,0,1}};
        floodFill(image,1,1,2);
    }
}
