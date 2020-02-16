package 栈和队列;
//用数组来实现循环队列
//通过增加size属性纪录
public class MyCircularQueue2 {
    int size;
    int[] array;
    int rear;
    int front;
    public MyCircularQueue2(int k){
         array=new int[k];
         size=0;
         rear=front=0;
    }
    //入队
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        //先将value放入rear后一个位置
        array[++rear] = value;
        size++;
        //判断位置是否越界，更新位置
        //rear=rear%array.length;
        if (rear == array.length) {
            rear = 0;
        }
        return true;
    }

    //出队
    public boolean deQueue(){
        if(isEmpty()){
            return  false;
        }
        front++;
        front=front%array.length;
        size--;
        return true;
    }

    //获得队头元素
    public int Front(){
        if(isEmpty()){
            return -1;
        }
        return array[front];
    }

    //获得队尾元素
    public int rear(){
        if(isEmpty()){
            return -1;
        }
        return array[rear];
    }

    //判断是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //判断是否满了
    public boolean isFull(){
        return size==array.length;
    }
}
