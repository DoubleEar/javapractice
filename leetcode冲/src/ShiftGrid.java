import java.util.ArrayList;
import java.util.List;

//给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
public class ShiftGrid {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ret=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            ret.add(new ArrayList<>());
        }
        int row1=grid.length;
        int col1=grid[0].length;
        // //如果k是二维数组元素个数的倍数,说明数组没有变化,直接返回
        k=k%(row1*col1);
        if(k==0){
            for(int i=0;i<row1;i++){
                for(int j=0;j<col1;j++){
                    ret.get(i).add(grid[i][j]);
                }
            }
        //进行迁移
        }else{
            int start=row1*col1-k;
            // 数组右移几位,开始遍历的时候起始位置就是倒数几位
            int row2=start/col1;
            int col2=start%col1;
            for(int i=0;i<row1;i++){
                for(int j=0;j<col1;j++){
                    ret.get(i).add(grid[row2][col2]);
                    col2++;
                    if(col2==col1){
                        col2=0;
                        row2++;
                    }
                    if(row2==row1)
                        row2=0;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] grid={
                {1,5,9},
                {10,11,13},
                {12,13,15}};
        System.out.println(shiftGrid(grid,5));
    }
}
