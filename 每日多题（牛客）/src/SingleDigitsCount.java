import java.util.Scanner;
//个位数的个数
public class SingleDigitsCount {
    private static void count(char[] c){
        int[] res=new int[9];
        for(char ch:c){
            res[ch-'0']++;
        }
        for(int i=0;i<res.length;i++){
            if(res[i]!=0){
                System.out.println(i+":"+res[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            char[] str=s.toCharArray();
            count(str);
        }
    }
}
