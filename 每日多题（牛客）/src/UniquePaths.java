//路径总数
//在一个m*n的网格的左上角有一个机器人，机器人在任何时候只能向下或者向右移动
// 机器人试图到达网格的右下角，有多少可能的路径。
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m<=0&&n<=0)
            return 0;

        int[][] res=new int[m][n];

        //初始化 F(0,i) = 1  F(i,0) = 1
        for(int i=0;i<m;i++){
            res[i][0]=1;
        }
        for(int i=1;i<n;i++){
            res[0][i]=1;
        }

        for(int i=1;i<m;i++){
            // 状态转移方程 F(i,j) = F(i-1,j) + F(i,j-1)
            for(int j=1;j<n;j++){
                res[i][j]=res[i-1][j]+res[i][j-1];
            }
        }
        //返回结果：F(m-1,n-1)
        return res[m-1][n-1];
    }
}
