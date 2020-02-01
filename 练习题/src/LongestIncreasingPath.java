//给定一个整数矩阵，找出最长递增路径的长度。
//对于每个单元格，你可以往上，下，左，右四个方向移动。
// 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
public class LongestIncreasingPath {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int m, n;

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;
        m = matrix.length;
        n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(matrix, i, j));
        return ans;
    }

    private static int dfs(int[][] matrix, int i, int j) {
        int ans = 0;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
                ans = Math.max(ans, dfs(matrix, x, y));
        }
        return ++ans;
    }

    public static void main(String[] args) {
        int[][] a={{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(a));
    }
}
