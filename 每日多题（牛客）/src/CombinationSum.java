import java.util.ArrayList;
import java.util.List;
//组合总和
//给定一个无重复元素的数组 candidates 和一个目标数 target
// 找出 candidates 中所有可以使数字和为 target 的组合。
//candidates 中的数字可以无限制重复被选取。
public class CombinationSum {
    //深搜+回溯
    private static void DFS(List<List<Integer>> solutions,List<Integer> solution,
                     int curSum,int target,int preIndex,int[] candidates){
        if(curSum>=target){
            if(curSum==target){     //当curSum=target时
                List<Integer> temp=new ArrayList<>();
                for(int n:solution)
                    temp.add(n);
                solutions.add(temp);
            }
            return;
        }

        //可以从上一个位置开始，因为元素可以重复。
        for(int i=preIndex;i<candidates.length;i++){
            if(curSum>target)
                continue;
            solution.add(candidates[i]);    //先一直累加当前的candidates[i]，在向后走
            DFS(solutions,solution,curSum+candidates[i],target,i,candidates);
            solution.remove(solution.size()-1);     //回溯
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solutions=new ArrayList<>();    //保留总结果
        List<Integer> solution=new ArrayList<>();   //保留中间的结果
        if(candidates.length==0)
            return solutions;
        int curSum=0;
        DFS(solutions,solution,curSum,target,0,candidates);
        return solutions;
    }

    public static void main(String[] args) {
        int[] candidates={2,3,6,7};
        int target=7;
        System.out.println(combinationSum(candidates,target));
    }
}
