import java.util.ArrayList;
import java.util.List;
//电话号码的组合数字
public class LetterCombinations {
    static String[] mapString={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    //深搜+回溯
    private static void DFS(String digits,List<String> ret,StringBuilder curStr,int depth){
        if(depth==digits.length()){     //当深搜的深度等于给定的位数时就加入结果list
            if(curStr.length()!=0){
                ret.add(curStr.toString());
                return;
            }
        }
        int mapStrIndex=digits.charAt(depth)-'0';   //判断当前是哪一个数字
        String curMap=mapString[mapStrIndex];   //找到数字对应的字符串

        for(int i=0;i<curMap.length();i++){
            //进行深搜
            DFS(digits,ret,curStr.append(curMap.charAt(i)),depth+1);
            //回溯
            curStr.deleteCharAt(curStr.length()-1);
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> ret=new ArrayList<>();
        StringBuilder curStr=new StringBuilder("");
        DFS(digits,ret,curStr,0);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
