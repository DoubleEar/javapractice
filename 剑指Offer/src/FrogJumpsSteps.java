//变态青蛙跳台阶
//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
public class FrogJumpsSteps {
    /*
        第一次跳一级台阶，剩下的n-1级台阶的跳法
        第二次跳两级台阶，剩下的n-2级台阶的跳法……
        f(n)=f(n-1)+f(n-2)+f(n-3)+……+f(1);
        同理f(n-1)=f(n-2)+f(n-3)+……+f(1);
        f(n)=f(n-1)+f(n-1)=2*f(n-1)------>等比数列1 2 4 8……
     */
    public static int JumpFloorII(int target) {
        /*
        if(target==1)
            return 1;
        return (int)Math.pow(2,target-1);
        */

        int ret=1;
        for(int i=2;i<=target;i++){
            ret*=2;
        }
        return ret;

        //return 1<<(target-1);
    }

    public static void main(String[] args) {
        int n=2;
        System.out.println(JumpFloorII(n));
    }
}
