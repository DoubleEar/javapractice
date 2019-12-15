//给定一个正整数，检查他是否为交替位二进制数：
// 换句话说，就是他的二进制数相邻的两个位数永不相等

public class AlternatingBinaryNumber {
    public boolean hasAlternatingBits(int n) {
        int m=n;
        boolean first=true;
        int bit=0;  //保存上一个最低位
        while(m!=0){     // m == 0 表示全是 0 了
            if(first==true){
                bit=m&1;
                first=false;
            }else{
                if((m&1)==bit){
                    return false;
                }
                bit=m&1;    // 取最低位
            }
            m=m>>1;  // 不要最低位
        }
        return true;
    }
}
