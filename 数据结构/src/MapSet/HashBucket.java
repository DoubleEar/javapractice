package MapSet;

//解决哈希冲突——哈希桶/拉链法。
public class HashBucket {
    private static class Node{
        int key;
        int value;
        Node next=null;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
            next=null;
        }
    }

    private Node[] array;
    private int size;
    //一般负载因子最大为0.7。
    private static final double LOAD_FACTORY=0.7;

    public HashBucket(){
        array=new Node[10];
        size=0;
    }

    //负载因子
    public double loadFactory(){
        return size*1.0/array.length;
    }

    public int put(int key,int value){
        //检查容量
        if(loadFactory()>=LOAD_FACTORY)
            //增容
            resize();

        //插入
        //1.计算哈希值
        int index=key%array.length;
        //2.不能插入重复的value,首先要查看key是否已经存在，遍历当前位置的单链表。
        Node cur=array[index];
        while (cur!=null){
            //如果存在就更新key的value
            if(cur.key==key) {
                int oldV=cur.value;
                cur.value=value;
                return oldV;
            }
            cur=cur.next;
        }
        //3.插入：单链表的头插。
        cur=new Node(key,value);
        cur.next=array[index];
        array[index]=cur;

        ++size;
        return -1;
    }

    private void resize() {

    }
}
