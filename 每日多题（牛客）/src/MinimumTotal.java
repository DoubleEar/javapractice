import java.util.ArrayList;
//三角矩阵
// 给定一个三角矩阵，找出自顶向下的短路径和，每一步可以移动到下一行的相邻数字
public class MinimumTotal {
    /*
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.isEmpty())
            return 0;
        ArrayList<ArrayList<Integer>> minPathSum=new ArrayList<>();
        for(int i=0;i<triangle.size();i++){
            minPathSum.add(new ArrayList<>());
        }

        //初始化F(0,0)=triangle[0][0];
        minPathSum.get(0).add(triangle.get(0).get(0));
        for(int i=1;i<triangle.size();i++){
            int curSum=0;
            for(int j=0;j<=i;j++){
                if(j==0)    //第一列的curSum只能从上一行来
                    curSum=minPathSum.get(i-1).get(j);
                else if(j==i)   //最后一列的curSum只能从上一行的前一列来
                    curSum=minPathSum.get(i-1).get(j-1);
                else
                    //状态转移方程  F(i,j) = min( F(i-1, j-1), F(i-1, j)) + triangle[i][j]
                    curSum=Math.min(minPathSum.get(i-1).get(j),
                            minPathSum.get(i-1).get(j-1));

                minPathSum.get(i).add(triangle.get(i).get(j)+curSum);
            }
        }

        int size=triangle.size();
        int lastMin=minPathSum.get(size-1).get(0);
        for(int i=1;i<size;i++){
            lastMin=Math.min(minPathSum.get(size-1).get(i),lastMin);
        }

        //返回值  min(F(n-1, i))  在最后一行中选择最小值并返回
        return lastMin;
    }
    */

    //逆向思维，从下往上遍历，不用做边界处理以及最后一行的选择。
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.isEmpty())
            return 0;
        //初始化
        ArrayList<ArrayList<Integer>> minPathSum=new ArrayList<>(triangle);
        int row=minPathSum.size();  //行数
        for(int i=row-2;i>=0;i--){  //从倒数第二行开始
            int curSum=0;
            for(int j=0;j<=i;j++){  //本行的curSum从下一行的当前列与下一行的后一列中选择最小值
                //F(i,j) = min( F(i+1, j), F(i+1, j+1)) + triangle[i][j]
                curSum=Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1))
                        +triangle.get(i).get(j);

                minPathSum.get(i).set(j,curSum);    //设置第j列的数据为curSum
            }
        }
        return (minPathSum).get(0).get(0);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle=new ArrayList<>();
        ArrayList<Integer> l1=new ArrayList<>();
        l1.add(2);
        triangle.add(l1);
        ArrayList<Integer> l2=new ArrayList<>();
        l2.add(3);
        l2.add(4);
        triangle.add(l2);
        ArrayList<Integer> l3=new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        triangle.add(l3);
        ArrayList<Integer> l4=new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        triangle.add(l4);

        System.out.println(minimumTotal(triangle));
    }
}
