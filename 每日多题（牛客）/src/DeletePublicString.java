import java.util.Scanner;
//删除公共字符串
public class DeletePublicString {
    private static void deletePublicString(String s1,String s2){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s1.length();i++){
            //如果要删除的字符串中不包含当前字符
            if(!s2.contains(s1.charAt(i)+"")){
                //就append进sb中
                sb.append(s1.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            deletePublicString(s1,s2);
        }
    }
}
