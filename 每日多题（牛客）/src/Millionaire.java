//百万富翁问题
public class Millionaire {
    public static void main(String[] args) {
        int a=10*30;
        int res = 0;
        for(int i=0;i<30;i++){
            res+=Math.pow(2,i);
        }
        System.out.println(a+" "+res);
    }
}
