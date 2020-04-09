//机器人走路
//机器人只能向下走或者向右走。从左上角走到右下角。
//求机器人有多少种走法。
public class Robot {
    private static int check(int i,int j,int[][] borad,int row,int col){
        if(i>=row||i<0||j>=col||j<0)
            return 0;
        if(i==row-1&&j==col-1)
            return 1;
        return  check(i+1,j,borad,row,col)
                +check(i,j+1,borad,row,col);
    }
    public static int countWays(int x, int y) {
        int[][] board=new int[x][y];
        int row=board.length;
        int col=board[0].length;
        int res=check(0,0,board,row,col);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countWays(2, 2));
    }
}
