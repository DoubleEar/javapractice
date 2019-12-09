package 栈和队列;
//用单向链表实现队列
    class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
            this.next = next;
        }
    }
    public class Queue {
         Node front=null;
         Node rear=null;
         int size=0;
    public Queue(){
        front=rear=null;
        size=0;
    }

    public void offer(int value){
        //尾插
        Node newNode=new Node(value);
        if(front==null) {
            front = rear = newNode;
        }else {
            rear = rear.next;
        }
        rear.next=newNode;
        size++;
    }

    public void poll(){
        //头删
        if(front==null)
            return ;
        front=front.next;
        if(front==null)
            rear=null;
        size--;
    }

    public int peek(){
        if(front==null)
            return -1;
        return front.value;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size==0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Queue queue=new Queue();
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println("遍历：");
        while(!queue.isEmpty()) {
            System.out.print(queue.peek());
            queue.poll();
        }

    }

}
