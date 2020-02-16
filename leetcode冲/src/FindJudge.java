public class FindJudge {
    public static int findJudge(int N, int[][] trust) {
        //被标记的人有N个，数组下标从0开始，所以新数组的长度为N+1
        //从1开始纪录每个人获得的票数
        int[] res=new int[N+1];
        for(int[] arr:trust){
            //j给每一个数组中信任别人的人减票（--）
            res[arr[0]]--;
            //给每一个数组中被信任的人投票（++）
            res[arr[1]]++;
        }
        for(int i=1;i<=N;i++){
            //当n某个人获得除了自己以外的所有人的票时，就是法官。
            if(res[i]==N-1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust={{1,2},{3,2}};
        System.out.println(findJudge(3,trust));
    }
}
