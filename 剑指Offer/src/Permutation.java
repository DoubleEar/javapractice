import java.util.*;

//字符串的排列
public class Permutation {
    private static void swap(char[] c,int i,int j){
        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }

    public static String[] permutation(String s) {
        //a)将字符串分为两部分：一部分是字符串第一个字符，另一部分是第一个字符以后的所有字符。
        //b)那第一个字符和它后面的字符逐个交换，确定第一个字符。
        char[] c=s.toCharArray();
        List<String> list=new ArrayList<>();
        dfs(c,0,list);
        return list.toArray(new String[list.size()]);
    }

    private static void dfs(char[] c,int x,List<String> list){
        if(x==c.length-1)
            list.add(String.valueOf(c));

        Set<Character> set=new HashSet<>();
        for(int i=x;i<c.length;i++){
            if(set.contains(c[i]))  //剪枝去重，例如"abb"
                continue;
            set.add(c[i]);
            //交换元素,当在第二层dfs(1),x = 1,那么i = 1或者2，
            //要么交换1和1，要么交换1和2
            swap(c,i,x);

            //进入下一层递归固定一个元素，后面的元素继续递归
            dfs(c,x+1,list);

            //回复交换，这样不会出现多余的可能
            //"abc" 每次递归返回时是a与a a与b a与c交换。所以第一个位置要固定保持不变。
            swap(c,i,x);
        }
    }

    public static void main(String[] args) {
        String s="abc";
        System.out.println(Arrays.toString(permutation(s)));
    }
}
