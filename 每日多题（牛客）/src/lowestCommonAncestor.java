//最近公共祖先
public class lowestCommonAncestor {
    public static int getLCA(int a, int b) {
        //完全二叉树中，parent=child/2。
        if(a==b)
            return a;
        while (a!=b){
            a=a>b?a/2:a;
            b=b>a?b/2:b;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getLCA(2, 3));
    }
}
