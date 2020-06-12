//路径总数带障碍
//机器人还是要从网格左上角到达右下角，但是网格中添加了障碍物，障碍物用1表示 。
public class UniquePathsWithObstacles {
    public static int uniquePathsWithObstacles (int[][] obstacleGrid) {
        if(obstacleGrid==null)
            return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] res=new int[m][n];

        //初始化第一列
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1)
                res[i][0]=0;
            else if(i>0) {  //如果之前有障碍物，后面的路也通不了
                if(res[i-1][0]==1)
                    res[i][0] = 1;
                else
                    res[i][0]=0;
            }
            else
                res[i][0]=1;
        }
        //初始化第一行
        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]==1)
                res[0][i]=0;
            else if(i>0) {  //如果之前有障碍物，后面的路也通不了
                if(res[0][i-1]==1)
                    res[0][i] = 1;
                else
                    res[0][i]=0;
            } else
                res[0][i]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]!=1){
                    // 状态转移方程 F(i,j) = F(i-1,j) + F(i,j-1)
                    res[i][j]=res[i-1][j]+res[i][j-1];
                }
            }
        }
        //返回结果：F(m-1,n-1)
        return res[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid={{0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
