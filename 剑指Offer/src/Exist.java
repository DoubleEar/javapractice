//用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
public class Exist {
    private static boolean find(char[][] board,boolean[][] visited,char[] word,int i,int j,int k){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
            return false;
        if (visited[i][j] || board[i][j] !=word[k])
            return false;
        if(k == word.length - 1)//走到最后一个字母，并且等于当前字符，说明成功了。
            return true;
        visited[i][j]=true;
        //当前字符任何一个方向符合条件返回true。
        if (find(board, visited,word, i + 1, j,k+1) || find(board,visited,word, i - 1, j,k+1)
                || find(board, visited, word,i, j + 1,k+1) || find(board, visited, word,i, j - 1,k+1))
            return true;
        visited[i][j]=false;
        return false;
    }
    public static boolean exist(char[][] board, String word) {
        int row=board.length,col=board[0].length;
        boolean[][] visited=new boolean[row][col];//用来标记该坐标是否有被访问过。
        char[] c=word.toCharArray();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(find(board,visited,c,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board={{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        System.out.println(exist(board,"bfce"));
        System.out.println(exist(board,"abfb"));
    }
}
