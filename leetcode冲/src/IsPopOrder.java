import java.util.Stack;

//判断一串序列是否是另一串序列压栈后可能出栈的顺序
public class IsPopOrder {
    public static boolean isPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        if (pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);

            //栈顶元素是否等于要预计要出栈的元素，如果等于就pop
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        //如果匹配，栈应该是空的
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA={1,2,3,4,5};
        int[] popA={4,5,3,2,1};
        System.out.println(isPopOrder(pushA,popA));
    }
}
