import java.util.*;
//旧键盘
public class BrokenKeyboard {
    private static void brokenKeyboard(String original,String broken){
        List<Character> list=new ArrayList<>();
        Set<Character> set=new TreeSet<>();
        char[] c1=original.toUpperCase().toCharArray();
        char[] c2=broken.toUpperCase().toCharArray();
        for(int i=0;i<broken.length();i++){
            set.add(c2[i]);
        }

        for(char ch:c1){
            if(!set.contains(ch)){
                if(!list.contains(ch))
                list.add(ch);
            }
        }

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String original=sc.nextLine();
            String broken=sc.nextLine();

            brokenKeyboard(original,broken);
        }
    }
}
