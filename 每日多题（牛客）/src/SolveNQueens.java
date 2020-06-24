import java.util.ArrayList;
import java.util.List;

//N皇后
class point{
    public int x;
    public int y;
    public  point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class SolveNQueens {
    //给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
    //每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
    private static void DFS(List<List<point>> solutions,List<point> solution,int curRow,int n){
        if(curRow==n){  //当遍历到最后一行的下一行的时候，说明遍历完了，并且为一种完整的方案。
            List<point> curList=new ArrayList<>();
            for(point i:solution){
                curList.add(i);
            }
            solutions.add(curList);
            return;
        }
        for(int i=0;i<n;i++){   //从第0行开始深度优先遍历
            if(IsValid(solution,curRow,i)){     //如果该位置合法
                solution.add(new point(curRow,i));  //加坐标到solution
                DFS(solutions,solution,curRow+1,n); //遍历下一行
                solution.remove(solution.size()-1); //回溯
            }
        }
    }

    private static boolean IsValid(List<point> solution,int row,int col){
        for(point i:solution)
            if(col==i.y         //判断是否在同一列同一对角线
                    ||i.x+i.y==row+col
                    ||i.x-i.y==row-col)
                return false;
        return true;
    }

    private static List<List<String>> _toString(List<List<point>> solutions,int n){
        //solutions中装的是符号条件的皇后的坐标。
        List<List<String>> ret=new ArrayList<>();
        for(List<point> points:solutions){
            //将一种方案转换为字符串形式
            List<StringBuilder> solutionString=new ArrayList<>();
            for(int i=0;i<n;i++){   //先构建一个为n*n的全为‘.’的矩阵
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++)
                    sb.append('.');
                solutionString.add(sb);
            }

            for(point i:points)     //一种方案中的皇后对应的坐标置为‘Q’
                solutionString.get(i.x).setCharAt(i.y,'Q');

            List<String> curString=new ArrayList<>();   //将转换好的一种方案加入ret
            for(StringBuilder sb:solutionString)
                 curString.add(sb.toString());

            ret.add(curString);
        }
        return ret;
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<point>> solutions=new ArrayList<>();
        List<point> solution=new ArrayList<>();
        DFS(solutions,solution,0,n);
        return _toString(solutions,n);
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
