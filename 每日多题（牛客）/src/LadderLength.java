import java.util.*;
//单词接龙
/*
    给定两个单词（beginWord 和 endWord）和一个字典
    找到从 beginWord 到 endWord 的最短转换序列的长度。
    转换需遵循如下规则：
	每次转换只能改变一个字母。
	转换过程中的中间单词必须是字典中的单词。
 */
public class LadderLength {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(String word:wordList){  //提高查询效率
            set.add(word);
        }

        HashSet<String> visited=new HashSet<>();    //标记单词有没有被访问过
        visited.add(beginWord);
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        int res=1;  //默认进行第一次转换
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size--!=0){
                //每一步都要把队列中上一步增加的所有单词转换一遍
                //所有这些词的转换只能算一次转化
                //因为都是上一步转换出来的
                String curWord=queue.poll();
                //尝试转换当前单词的每一个位置
                for(int i=0;i<curWord.length();i++){
                    StringBuilder newWord=new StringBuilder(curWord);
                    //每一个位置用26个字母分别替换
                    for(char c='a';c<='z';c++){
                        newWord.setCharAt(i,c);

                        String changeWord=newWord.toString();
                        //列表中没有此单词或者已经遍历过 剪枝
                        if(!set.contains(changeWord)||visited.contains(changeWord))
                            continue;

                        //转换成功
                        if(changeWord.equals(endWord))
                            return res+1;

                        queue.offer(changeWord);
                        visited.add(changeWord);
                    }
                }
            }
            res++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord="hit";
        String endWord="cog";
        List<String> wordList=new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
}
