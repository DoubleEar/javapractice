public class MyArrayList<E> {
    //泛型的应用
    private E[] array;
    private int size;
    MyArrayList(){
        array=(E[])new Object[10];
        size=0;
    }
    public void add(E element){
        array[size++]=element;
    }

    public E get(int index){
        return array[index];
    }

    public static void main(String[] args) {
        MyArrayList<String>list=new MyArrayList<>();
        list.add("String");
        list.add("List");
        System.out.println(list.get(1));
    }
}
