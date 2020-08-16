import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//撤销与恢复
public class RevocationAndReply {
    private static String calculateRes(String[] str){
        List<String> list=new ArrayList<>();
        String prev=null;
        int count=0;
        for(int i=0;i<str.length;i++){
            if(str[i].equals("undo")) {
                if(list.size()>0) {
                    prev = list.remove(list.size() - 1);
                    count++;
                }
            }else if(str[i].equals("redo")){
                if(count>0) {
                    list.add(prev);
                    count--;
                }
            }else {
                list.add(str[i]);
            }
        }

        if(list.isEmpty())
            return null;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)+" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            String[] str=s.split("\\s");
            System.out.println(calculateRes(str));
        }
    }
}
