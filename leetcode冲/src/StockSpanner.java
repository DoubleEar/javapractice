import java.util.Stack;

//小于或等于今天价格的最大连续日数(注意是连续)
public class StockSpanner {
    Stack<Integer> prices,weight;
    public StockSpanner(){
        //定义一个单调（递减）栈
        prices=new Stack<>();
        //维护单调栈，计算权重。
        weight=new Stack<>();
    }
    public int next(int price) {
        //每到下一个数将weight的值置为1
        int w=1;
        //当当前栈顶元素小于或等于要入栈的元素时
        while(!prices.isEmpty()&&prices.peek()<=price){
            //将当前栈顶元素pop
            prices.pop();
            //将要入栈的元素权重加一
            w+=weight.pop();
        }
        prices.push(price);
        weight.push(w);
        return w;
    }
}
