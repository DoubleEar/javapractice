import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//打开转盘锁
public class OpenLock {
    /*
        锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
        列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
        字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     */
    public static int openLock(String[] deadends, String target) {
        Set<String> set=new HashSet<>();    //便于查找
        for(String s:deadends)
            set.add(s);

        if(set.contains("0000"))    //初始化 锁都是从‘0000’开始的。
            return -1;
        Queue<String> queue=new LinkedList<>();
        queue.offer("0000");

        Set<String> visited=new HashSet<>();    //标记set
        visited.add("0000");

        int step=0;

        while (!queue.isEmpty()){
            int size=queue.size();
            while (size--!=0){
                //上一步转换后的字符串都需要重新转换或者验证
                //并且只算做一次的转换。
                    String curStr=queue.poll();
                    if(curStr.equals(target))
                        return step;

                    for(int j=0;j<4;j++){   //有四位密码 每个位上的数字都让它加或者减
                        char c1=curStr.charAt(j);
                        char c2=curStr.charAt(j);

                        if(c1=='0')
                            c1='9';
                        else
                            c1--;

                        if(c2=='9')
                            c2='0';
                        else
                            c2++;

                        StringBuilder sb1=new StringBuilder(curStr);
                        StringBuilder sb2=new StringBuilder(curStr);

                        sb1.setCharAt(j,c1);
                        sb2.setCharAt(j,c2);


                        //已经搜索过的字符串不用再搜索
                        if(!(set.contains(sb1.toString())||visited.contains(sb1.toString()))){
                            queue.offer(sb1.toString());
                            visited.add(sb1.toString());
                        }

                        if(!(set.contains(sb2.toString())||visited.contains(sb2.toString()))){
                            queue.offer(sb2.toString());
                            visited.add(sb2.toString());
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        System.out.println(openLock(deadends,"0202"));
    }
}
