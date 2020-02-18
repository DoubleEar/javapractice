package 栈和队列;

//用数组来实现队列（非循环队列）
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue(3);
        System.out.println(queue.isEmpty());
        queue.addQueue(10);
        queue.addQueue(20);
        queue.addQueue(30);
        System.out.println(queue.isFull());
        System.out.println(queue.isEmpty());
        System.out.println(queue.headQueue());
        System.out.println(queue.getQueue());
        queue.showQueue();
    }

}
    class ArrayQueue{
        private int maxSize;//表示数组最大容量
        private int front;//队列头
        private int rear;//队列尾
        private int[] arr;
    public ArrayQueue(int arrMaxSize){
            maxSize=arrMaxSize;
            front=-1;//指向队列头部的前一个位置
            rear=-1;//指向队列尾的数据
            arr=new int[maxSize];
        }

        //判断队列是否为满
        public boolean isFull(){
            return rear==maxSize-1;
        }

        //判断队列是否为空
        public boolean isEmpty(){
            return rear==front;
        }

        //增加数据到队列
        public void addQueue(int n){
            //判断队列是否为满
            if(isFull()){
                System.out.println("队列已满，不能增加");
                return;
            }
            rear++;
            arr[rear]=n;
        }

        //获取队列元素，数据出队列
        public int getQueue(){
            //判断队列是否为空
            if(isEmpty()){
                throw new RuntimeException("队列为空，不能获取数据");
            }
            front++;
            return arr[front];
        }

        //显示队列所有数据
        public void showQueue(){
            if(isEmpty()){
                System.out.println("队列为空，没有数据。");
            }
            for(int i=0;i<arr.length;i++){
                System.out.printf("arr[%d]=%d\n",i,arr[i]);
            }
        }

        //获取队头元素
        public int headQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空，没有队头元素");
            }
            return arr[front+1];
        }

    }

