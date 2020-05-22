import java.util.Scanner;
//坐标移动
// A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
// 从（0,0）点开始移动。横坐标左右、纵坐标上下。
public class CoordinateMovement {
    private static void move(String[] s){
        int x=0;
        int y=0;
        for(int i=0;i<s.length;i++) {
            if (checkLegality(s[i])) {
                String str = s[i].substring(1);
                char c = s[i].charAt(0);
                if (c == ('A')){
                    x -= Integer.valueOf(str);
                }else if(c == ('D')){
                    x += Integer.valueOf(str);
                } else if (c == ('W')) {
                    y += Integer.valueOf(str);
                }else if(c == ('S'))
                    y -= Integer.valueOf(str);
            }
        }
        System.out.println(x+","+y);
    }

    private static boolean checkLegality(String s){
        if(s.length()<2||s.length()>3)
            return false;
        if(s.length()==3){
            int a=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='A'||s.charAt(i)=='W'||s.charAt(i)=='S'||s.charAt(i)=='D'){
                    a++;
                }
            }
            if(a==1&&s.charAt(0)=='A'||s.charAt(0)=='W'||s.charAt(0)=='S'||s.charAt(0)=='D')
                return true;
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            String[] str=s.split(";");
            move(str);
        }
    }
}
