//机器人的运动范围
public class MovingCount {
    private static int movingCountCore(int m,int n,int i,int j,int k,boolean[][] visited){
        int count=0;
        if(check(m,n,i,j,k,visited)){
            visited[i][j]=true;//对遍历到的的坐标进行标记。
            count=1+movingCountCore(m,n,i-1,j,k,visited)
                    +movingCountCore(m,n,i+1,j,k,visited)
                    +movingCountCore(m,n,i,j-1,k,visited)
                    +movingCountCore(m,n,i,j+1,k,visited);
        }
        return count;
    }

    //判断该坐标对应的元素是否合法
    private static boolean check(int m,int n,int i,int j,int k,boolean[][] visited){
        if(i<m&&i>=0&&j<n&&j>=0&&getDigitSum(i)+getDigitSum(j)<=k&&!visited[i][j]){
            return true;
        }
        return false;
    }

    //对当前坐标进行分解求和
    private static int getDigitSum(int n){
        int sum=0;
        while (n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }


    public static int movingCount(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];
        return movingCountCore(m,n,0,0,k,visited);
    }

    public static void main(String[] args) {
        System.out.println(movingCount(3,3,2));
    }
}
