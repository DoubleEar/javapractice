import java.util.Scanner;
//字母统计
public class CountCharacter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            char[] c=s.toCharArray();
            int[] res=new int[26];
            for(int i=0;i<s.length();i++){
                if(c[i]>='A'&&c[i]<='Z'){
                    res[c[i]-'A']++;
                }
            }
            int index=0;
            for(int i='A';i<='Z';i++){
                System.out.println((char)i+":"+res[index++]);
            }
        }
    }
}
