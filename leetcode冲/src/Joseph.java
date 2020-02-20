import java.util.Iterator;
import java.util.LinkedList;

//约瑟夫问题
public class Joseph {
    public static int getResult(int n) {
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        //起始的步长为2
        int origenStep=2;
        //遍历链表，直到只剩一个元素时退出
        while(list.size()>1) {
            //将报数过程中与origenStep取余值为非1的值设为-1，方便后面删除
            for (int i = 0; i < list.size(); i++) {
                //与2取模的结果1、0，正好使报2的人被删除
                if ((i + 1) % origenStep != 1)
                    list.set(i,-1);
            }
            //一轮报数结束后步长加一。
            //与3取模得到的结果1、2、0，正好使报2、3的人被删除。
            origenStep++;
            //迭代器，删除被标记的元素
            Iterator<Integer> iter=list.iterator();
            while(iter.hasNext()){  //如果迭代器中还有元素，则返回true
                if(iter.next()==-1){    //返回游标当前元素并将游标移动到下一个位置
                    iter.remove();  //删除游标左面的元素。
                }
            }
            //一轮结束后，将最后的元素移到首位，即实现从上轮的最后一个人开始报数
            list.addFirst(list.removeLast());
        }
        //当列表中只有一个元素时，跳出循环，并返回。
        int num=list.get(0);
        return num;
    }

    public static void main(String[] args) {
        System.out.println(getResult(5));
    }
}
