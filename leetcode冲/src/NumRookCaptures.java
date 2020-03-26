//在一个 8 x 8 的棋盘上，返回消灭卒（p）的个数。
//从R出发向四周寻找，遇到同盟军B终止。
public class NumRookCaptures {
    public static int numRookCaptures(char[][] board) {
        // 因为题目已经明确给出 board.length == board[i].length == 8，所以不做输入检查
        // 定义方向数组，可以认为是四个方向向量，在棋盘问题上是常见的做法
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (board[i][j] == 'R') {
                    int res = 0;
                    for (int[] direction : directions) {
                        if (burnout(board, i, j, direction)) {
                            res++;
                        }
                    }
                    return res;
                }
            }
        }
        // 代码不会走到这里，返回-1或者抛出异常均可
        return -1;
    }

    private static boolean burnout(char[][] board, int x, int y, int[] direction) {
        int i = x;
        int j = y;
        while (inArea(i, j)) {
            // 是友军，路被堵死，直接返回
            if (board[i][j] == 'B') {
                break;
            }

            // 是敌军，拿下。
            if (board[i][j] == 'p') {
                return true;
            }

            //依次向四个方向展开进攻（调用一次向某一个方向一直遍历）。
            i += direction[0];
            j += direction[1];
        }
        return false;
    }

    private static boolean inArea(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(numRookCaptures(board));
    }
}
