public class AddByBitwise {
    /*
        对于异或：0^0=0,1^0=1,1^1=0，可以实现数字无进位相加。
        再用与运算0&0=0,1&0=0,1&1=1，将与运算的结果左移1位即可变为进位位。
        一直加到进位位为0结束计算。
     */
        public static int addAB(int A, int B) {
            if (B!=0){
                int a=A^B;
                int b=(A&B)<<1;
                return addAB(a,b);
            }else
                return A;
    }

    public static void main(String[] args) {
        System.out.println(addAB(1,2));
    }
}
