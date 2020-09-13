//求1+2+…+n
// 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
public class SumNums {
    //方法一：使用运算符的短路特性+递归
    public static int sumNums(int n) {
        boolean flag=n>0 && (n+=sumNums(n-1))>0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(3));
    }
}
