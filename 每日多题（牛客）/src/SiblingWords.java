import java.util.*;
//查找兄弟单词
public class SiblingWords {
    private static void findSimilar(String[] str,String s,int n){
        List<String> list=new ArrayList<>();
        char[] ch=s.toCharArray();  //目标单词
        Arrays.sort(ch);    //按照字典序排列

        for(int i=0;i<str.length;i++){
            if(str[i].length()==s.length()) {
                if (s.contains(str[i]))     //字典中的单词和目标单词一样，不符合要求。
                    continue;

                char[] c = str[i].toCharArray();    //对字典中的单词进行字典序排序
                Arrays.sort(c);

                boolean flag=true;

                //考虑一个单词中有重复的字符的情况，所以用字典序排列之后比较。
                for (int j = 0; j < c.length; j++) {    //如果一个不同就beak
                    if(c[j]!=ch[j]) {
                        flag=false;
                        break;
                    }
                }

                if(flag) {
                    list.add(str[i]);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
            if(!list.isEmpty()&&list.size()>=n) {   //输出兄弟单词的第n个
                System.out.println(list.get(n - 1));
            }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            String[] str=new String[n];
            for(int i=0;i<n;i++){
                str[i]=sc.next();
            }

            String target=sc.next();

            int m=sc.nextInt();

            findSimilar(str,target,m);
        }
    }
}
