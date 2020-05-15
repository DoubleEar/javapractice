import java.util.Stack;
//栈的压入、弹出序列
public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack=new Stack<>(); //辅助栈
        int index=0;
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);

            while (!stack.isEmpty()&&stack.peek()==popped[index]){
                    //如果stack的栈顶元素等于出栈数组中的当前元素，则stack.pop()。
                    stack.pop();
                    //下标向后移动
                    index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed={1,2,3,4,5};
        int[] popped={4,5,3,2,1};

        System.out.println(validateStackSequences(pushed,popped));
    }
}
