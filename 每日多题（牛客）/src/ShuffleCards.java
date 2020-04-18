import java.util.Scanner;
//洗牌
public class ShuffleCards {
    private static void shuffleCards(int[] group,int n,int k){
        int[] res=new int[2*n];//用来放置洗过之后的牌
        while (k>0) {
            int i = 2 * n - 1;//第二堆最后一张牌
            int j = n - 1;//第一堆最后一张牌
            for(int index=2*n-1;index>=1;index--){
                if(j>=0&&i>=n){
                    res[index--]=group[i--];
                    res[index]=group[j--];
                }
            }
            k--;
            //更新group
            if(k>0){
                group=res.clone();
            }
        }
        //输出
        for(int i=0;i<res.length;i++){
            if(i==res.length-1){
                System.out.print(res[i]);
            }else {
                System.out.print(res[i] + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int groups=sc.nextInt();//牌的组数 3->有3组牌要洗
        while (groups>0){
            int n=sc.nextInt();//牌的个数 要洗2*n张牌
            int k=sc.nextInt();//洗牌的次数 2->洗两次
            int[] group=new int[2*n];
            //先将每一组的牌的值装入group数组中
            for(int i=0;i<group.length;i++){
                group[i]=sc.nextInt();
            }
            groups--;
            //洗牌
            shuffleCards(group,n,k);
        }
    }
}
