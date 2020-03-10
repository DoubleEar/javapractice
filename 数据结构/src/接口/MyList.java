package 接口;
//泛型
import java.util.Arrays;
//静态成员(属性和函数)不能定义成泛型
//非静态内部类可以使用外部类的泛型参数
//静态内部类不能使用外部类的泛型参数


class MyList<E extends Number>{
    //通配符 ？：对类型没有限制
    public static void fun1(MyList<?> ml){

    }
    //? extends 类型：指明类型的上界
    public static void fun2(MyList<?extends Integer> ml){

    }
    //? super 类型：指明类型的下界，最低要求。
    public static void fun3(MyList<?super Number> ml){

    }
    public static void main(String[] args) {

        MyList<Integer> ml=new MyList<>();
        MyList<Number> ml2=new MyList<>();
        //Object定义时超出上界
        //MyList<Object> ml3=new MyList<Object>();

        fun1(ml);
        fun1(ml2);

        fun2(ml);
        //Number已经超出上界
        //fun2(ml2);

        //Integer不是Number类型的父类或者Number本身
        //fun3(ml);
        fun3(ml2);

    }
}


 class MyArrayList<E> {
    private E[] array;
    private int size;
    private int capacity;

    MyArrayList(){
        array=(E[])new Object[10];
        size=0;
        capacity=10;
    }

    //头插
    public void add(E value){
        if(size==capacity){
            array=Arrays.copyOf(array,2*capacity);
            capacity*=2;
        }
        array[size++]=value;
    }
    //头删
    public E remove(){
        E ret;
        if(size>0) {
            ret = array[size - 1];
            array[size - 1] = null;
            size--;
            return ret;
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void print(){
        for(E e:array){
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void test1(){
        MyArrayList<Integer> ml=new MyArrayList<>();
        ml.add(1);
        ml.add(2);
        ml.add(3);
        ml.add(4);
        ml.print();
        System.out.println(ml.remove());

        MyArrayList<Character> ml2=new MyArrayList<>();
        ml2.add('1');
        ml2.add('2');
        ml2.add('3');
        ml2.add('4');
        ml2.print();
        System.out.println(ml2.remove());
     }
     public static void main(String[] args) {
         test1();
     }
}

class MyLinkedList<E>{
    Node head;
     //头插
    public void pushFront(E value){
         if(head==null)
             head=new Node<>(value);
         else{
             Node<E> node=new Node<>(value);
             node.next=head;
             head=node;
         }
    }

    public E popFront(){
         E ret = (E) head.value;
         head=head.next;
         return ret;
    }

    public void print(){
        Node<E> cur=head;
        while (cur!=null){
            System.out.print(cur.value);
            cur=cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> mll=new MyLinkedList<>();
        mll.pushFront(4);
        mll.pushFront(3);
        mll.pushFront(2);
        mll.pushFront(1);
        mll.print();
        System.out.println(mll.popFront());
    }
}

class A implements Comparable<A>{

    @Override
    public int compareTo(A o) {
        return 0;
    }
}
class C{

}

class B <E extends Comparable<E>,T>{
    //E必须是Comparable类的子类，T随便都可以。
    public static void main(String[] args) {
        //Integer中可以比较
        B<Integer,Integer> b=new B<>();
        //C类没有实现CompareTo方法
        //B<C,Character> b1=new B<>();
        B<A,Character> b2=new B<>();
    }
}


