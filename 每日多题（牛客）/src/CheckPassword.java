import java.util.Scanner;
//密码验证程序
public class CheckPassword {
    //判断长度
    private static boolean judgeLength(String s){
        if(s.length()<9)
           return false;
        else
            return true;
    }

    //判断是否有长度大于2重复的字串
    private static boolean judgeRepeat(char[] chars){
        int a=0,b=0,c=0,d=0;
        for(char ch:chars){
            if(ch>='1'&&ch<='9')
                a=1;
            else if(ch>='a'&&ch<='z')
                b=1;
            else if(ch>='A'&&ch<='Z')
                c=1;
            else
                d=1;
        }

        if((a+b+c+d)>2)
            return true;
        else
            return false;
    }

    //判断密码种类是否大于3
    private static boolean judgeKinds(char[] c){
        for(int i=0;i<c.length-6;i++){
            for(int j=i+3;j<c.length-3;j++){
                if(c[i]==c[j]&&c[i+1]==c[j+1]&&c[i+2]==c[j+2])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            char[] c=s.toCharArray();
            if(judgeLength(s)&&judgeRepeat(c)&&judgeKinds(c))
                System.out.println("OK");
            else
                System.out.println("NG");
        }
    }
}
