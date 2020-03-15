//岛屿的最大面积(岛屿只能包含水平或垂直的四个方向的‘1’。)
public class MaxAreaOfIsland {
    int row,col,res=0;
    public int maxAreaOfIsland(int[][] grid) {
        row=grid.length;
        col=grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                //如果当前位置是岛屿就看它的四个垂直方向。
                if(grid[i][j]==1){
                    int area=dfs(grid,i,j);
                    if(area>res)
                        res=area;
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid,int i,int j){
        if(i<0||i>=row||j<0||j>=col||grid[i][j]==0)
            return 0;

        //将遍历过的位置赋值为0，证明已经遍历过了。
        grid[i][j]=0;

        int num=1;
        //从四个垂直方向接着去遍历
        num+=dfs(grid,i,j-1);
        num+=dfs(grid,i,j+1);
        num+=dfs(grid,i-1,j);
        num+=dfs(grid,i+1,j);

        return num;
    }
}
