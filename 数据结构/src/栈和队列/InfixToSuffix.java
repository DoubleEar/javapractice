package 栈和队列;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//将中缀表达式，转换成后缀表达式。
public class InfixToSuffix {
    public static List<String> ToInfixExpressionList(String s){
        List<String> l1=new ArrayList<>();
        int i=0;//用于遍历中缀表达式
        String str;//用于拼接多位数
        char c;
        do{
            //如果c是一个非数字，就将它直接加入l1中
            if((c=s.charAt(i))<'0'||(c=s.charAt(i))>'9'){
                l1.add(""+c);
                i++;
            }else{
                str="";//先将字符串置为空
                while(i<s.length()&&(c=s.charAt(i))>'0'&&(c=s.charAt(i))<'9') {
                    str += c;//拼接
                    i++;
                }
                l1.add(str);
            }
        }while(i<s.length());
        return l1;
    }

    public static List<String> parseSuffixExperssionList(List<String> l1){
        Stack<String> s1=new Stack<>();//运算符栈
        List<String> s2=new ArrayList<>();//储存结果的顺序表
        for(String s:l1){
            //如果是数字
            if(s.matches("\\d+")){
                s2.add(s);
                //如果是左括号就入栈
            }else if(s.equals("(")){
                s1.push(s);
                //如果是右括号
            }else if(s.equals(")")){
                //就弹出s1栈顶元素直到遇到左括号
                while(!s1.peek().equals("(")){
                    //并加入顺序表表中
                    s2.add(s1.pop());
                }
                s1.pop();//将（弹出，消除小括号。
            }else {
                //运算符
                // 将优先级大的运算符加入s2。
                while(s1.size()!=0&&Operation.getValue(s1.peek())>=Operation.getValue(s)){
                    s2.add(s1.pop());
                }
                //还要将s1压入栈
                s1.push(s);
            }
        }
        //将s1剩余的运算符一次弹出加入s2
        while(s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }

    public static void main(String[] args) {
        InfixToSuffix ope=new InfixToSuffix();
        String experssion="1+((2+3)*4)-5";
        List<String> InfixExpressionList=ToInfixExpressionList(experssion);
        System.out.println(InfixExpressionList);
        System.out.println(parseSuffixExperssionList(InfixExpressionList));
    }
}
//判断运算符的优先级
class Operation {
    public  static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = 1;
                break;
            case "-":
                result = 1;
                break;
            case "*":
                result = 2;
                break;
            case "/":
                result = 2;
                break;
            default:
                break;
        }
        return result;
    }
}
