//1～n整数中1出现的次数
public class CountDigitOne {
    public static int countDigitOne(int n) {
        int cur=n%10,low=0,high=n/10;
        int digit=1,res=0;
        while (high!=0||cur!=0){
            if(cur==0)  //当cur=0时:此位1的出现次数只由高位high决定
                res+=high*digit;    //high×digit
            else if (cur==1)    //当cur=1时:此位1的出现次数由高位high和低位low决定
                res+=high*digit+low+1;  //high×digit+low+1
            else        //当 cur=2,3,⋯ ,9时：此位1的出现次数只由高位high决定
                res+=(high+1)*digit;    //(high+1)×digit

            low+=cur*digit;
            cur=high%10;
            high/=10;
            digit*=10;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(101));
    }
}
