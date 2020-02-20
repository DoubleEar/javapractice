package 栈和队列;
//用数组来实现循环队列
//保留一个位置
public class MyCircularQueue {
    int[] array;
    int front;//队头元素
    int rear;//队尾元素的下一个位置

    public MyCircularQueue(int k) {
        //预留一个位置
        array = new int[k + 1];
        front = rear = 0;
    }
    //插入队列头部
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        //插入队列头部，插入当前front的前一个位置
        front = (front - 1 + array.length) % array.length;
        array[front]=value;
        return true;
    }
    //入队（插入队列尾部）
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        //先将value放入rear的位置，在将rear后移一位
        array[rear++] = value;

        //判断位置是否越界，更新位置
        //rear=rear%array.length;
        if (rear == array.length) {
            rear = 0;
        }
        return true;
    }
    //出队（从队列头部删除一个元素）
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        //头删，front指向下一个元素
        front++;
        front = front % array.length;
        return true;

    }
    //从队列尾部删除一个元素
    public boolean deleteLast() {
        if(isEmpty()){
            return  false;
        }
        //将rear往前移动一位
        rear = (rear - 1 + array.length) % array.length;
        return true;
    }
    //获得队头元素
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];

    }
    //获得队尾元素
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        if (rear == 0) {
            return array[array.length - 1];
        }
        return array[rear - 1];
        //return array[(rear - 1 + array.length) % array.length];
    }

    //判断循环队列是否为空
    public boolean isEmpty() {
        return front == rear;

    }

    //判断循环队列是否已满
    public boolean isFull() {
        return (rear + 1) % array.length == front;
    }
}
