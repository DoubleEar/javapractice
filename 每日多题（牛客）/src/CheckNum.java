//输出1000~100000中是质数又是回文数的数
public class CheckNum {
    private static boolean isPalindrome(int i){
        String s=String.valueOf(i);
        int a=0,b=s.length()-1;
        while (a<b){
            if(Integer.valueOf(s.charAt(a++))!=Integer.valueOf(s.charAt(b--))) {
                return false;
            }
        }
        return true;
    }
    private static boolean isPrime(int i){
        for(int a=2;a<i;a++){
            if(i%a==0)
                return  false;
        }
        return true;
    }
    public static void main(String[] args) {
        for(int i=1000;i<=100000;i++){
            if(isPalindrome(i)&&isPrime(i)){
                System.out.println(i);
            }
        }
    }
}
