package 栈和队列;

import java.util.Stack;
//用栈完成表达式的计算（中缀表达式）
public class Calculator {
    int oper = 0;
    //判断操作符的优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }
    //判断是不是一个操作符
    public boolean isOper(int val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    //计算方法
    public int calculator(int num1,int num2,int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        int index=0,num1=1,num2=0,oper=0,res=0;
        int ch=' ';
        String keepNum="";//用于拼接多位数
        String expression="70+2*6-3";
        Calculator c=new Calculator();
        Stack<Integer> numStack=new Stack<>();//数栈
        Stack<Integer> operStack=new Stack<>();//符号栈
        while(true){
            //取到表达式的每一位
            ch=expression.substring(index,index+1).charAt(0);
            if(c.isOper(ch)){
                if(!operStack.isEmpty()){
                    //符号栈不为空
                    //当前符号的优先级小于栈中的符号
                    if(c.priority(ch)<=c.priority(operStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=c.calculator(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    //当前符号的优先级大于等于栈中的符号
                    }else {
                        operStack.push(ch);
                    }
                //符号为空
                }else{
                    operStack.push(ch);
                }
            //是数字
            }else {
                //从字符1转化成数字1
                //numStack.push(ch);单位数
                keepNum += ch-48;
                //如果ch已经是expression的最后一位，直接入栈就可以了。
                if (index == expression.length()-1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字。如果是数字就继续扫描。如果是运算符就直接入栈。
                    if (c.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //后一位是运算符
                        numStack.push(Integer.parseInt(keepNum));
                        //将keepNum清空
                        keepNum = "";
                    }
                }
            }
            //继续往后遍历
            index++;
            if(index>=expression.length()){
                break;
            }
        }
        //扫描完毕
        while(true){
            if(operStack.isEmpty()){
                break;
            }
            //按顺序计算每一位
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=c.calculator(num1,num2,oper);
            numStack.push(res);
        }
        System.out.println(numStack.pop());
    }
}
