//被包围的区域
//找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
public class SurroundingArea {
    /*
        找到边界的0，以及四个方向上的O，证明这些元素没有被X包围。先将这些元素标记，
        在找到被X包围的O，将他们替换为X。将没有被X包围的O还原为O。
     */
    static int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
    private static void DFS(char[][] board,int x,int y,int row,int col){
        board[x][y]='*';
        for(int i=0;i<4;i++){
            int newX=x+direction[i][0];
            int newY=y+direction[i][1];

            if(newX<0||newX>=row||newY<0||newY>=col)
                continue;

            if(board[newX][newY]=='O')
                DFS(board, newX, newY, row, col);
        }
    }
    public static void solve(char[][] board) {
        if(board==null||board.length==0)
            return;

        int row=board.length;
        int col=board[0].length;

        //寻找第一行和最后一行
        for(int i=0;i<col;i++){
            if(board[0][i]=='O')
                DFS(board,0,i,row,col);
            if(board[row-1][i]=='O')
                DFS(board,row-1,i,row,col);
        }

        //寻找第一列和最后一列
        for(int i=0;i<row;i++){
            if(board[i][0]=='O')
                DFS(board,i,0,row,col);
            if(board[i][col-1]=='O')
                DFS(board,i,col-1,row,col);
        }

        //还原以及扣题
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='*')
                    board[i][j]='O';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board={{'X','X','X','X'},
                        {'X','O','O','X'},
                        {'X','X','O','X'},
                        {'X','O','X','X'}};

        solve(board);
    }
}
