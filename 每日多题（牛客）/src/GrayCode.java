import java.util.Arrays;

//生成格雷码
//在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码。
public class GrayCode {
    /*
    1输出     0  、1
    2输出     00 、01、10、11
    3输出     000、001、010、011、100、101、110、111

    长度是上一个数的二倍，并且一半+0，一半+1。
     */
    public static String[] getGray(int n) {
        String[] str ;
        if(n==1){
            str = new String[]{"0","1"};
        }else{
            String[] s = getGray(n-1);
            str = new String[s.length * 2];
            for(int i = 0;i<s.length;i++){
                str[i] ="0" + s[i] ;
                str[str.length-1-i] = "1" + s[i] ;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getGray(2)));
    }
}
