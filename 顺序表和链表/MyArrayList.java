import java.util.Arrays;
public class MyArrayList{
	private int[] array;
	private int size;
	MyArrayList(){
		array=new int[10];
		size=0;
	}
	//尾插
	public void pushBack(int element){
		array[size]=element;
		size++;
		//array[size++]=element;
	}
	@Override
	public String toString(){
		return Arrays.toString(Arrays.copyOf(array,size));
	}
	//尾删
	public void popBack(){
		array[--size]=0;
	}
	public void pushFront(int element){
		for(int i=size;i>=1;i--){
			array[i]=array[i-1];
		}
		array[0]=element;
		size++;
	}
	//头删
	public void popFront(){
		/*if(size==0)
		System.out.println("空了");
		return;*/
		for(int i=1;i<=size-1;i++){
			//实心赋值给空心
			array[i-1]=array[i];
		}
		array[size]=0;
		--size;
	}
	public void insert(int element,int index){
		//实心 因为i确定的是实心的，所以i代表实心
		for(int i=size-1;i>=index;i--){
			array[i+1]=array[i];
		}
		array[index]=element;
		size++;
	}
	public static void main(String[] args){
		MyArrayList list=new MyArrayList();
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		System.out.println(list);
		list.popBack();
		list.popBack();
		System.out.println(list);
		list.pushFront(10);
		list.pushFront(20);
		System.out.println(list);
		list.popFront();
		System.out.println(list);
		list.insert(3,2);
		System.out.println(list);
	}
}