import java.util.Scanner;
//删除重复的字符
public class DeleteTheSameChar {
    private static String deleteString(String s1,String s2){
       StringBuilder sb=new StringBuilder();
       for(int i=0;i<s1.length();i++){
           if(!s2.contains(s1.charAt(i)+""))
               sb.append(s1.charAt(i));
       }
       return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            System.out.println(deleteString(s1,s2));
        }
    }
}
