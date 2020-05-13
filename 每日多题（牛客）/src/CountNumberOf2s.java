//1~n中2的个数
public class CountNumberOf2s {
    public static int countNumberOf2s(int n) {
        /*
        int res=0;
        for(int i=1;i<=n;i++){
            int temp=i;
            while (temp>0){
                if(temp%10==2){
                    res++;
                }
                temp/=10;
            }
        }
        return res;
        */


        //将数一位一位来计算：个位、十位、百位……
        //例：25267 用百位来示例
        int count=0;
        for(long i=1;i<=n;i*=10){
            //a用来表示当前位以及之前的 225
            //b用来表示当前位之后的 67
            long a=n/i,b=n%i;
            //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=2，补9会产生进位位，效果等同于(a/10+1)
            //百位正好等于2，a产生的可能性不变。b增加（0~b）种
            count+=(a+7)/10*i+((a%10==2)?b+1:0);
        }
        return count;
    }

    public static void main(String[] args) {
        int n1=10;
        int n2=20;
        int n3=28;
        int n4=40;

        System.out.println(countNumberOf2s(n1));
        System.out.println(countNumberOf2s(n2));
        System.out.println(countNumberOf2s(n3));
        System.out.println(countNumberOf2s(n4));
    }
}
