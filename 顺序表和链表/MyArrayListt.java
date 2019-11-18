import java.util.Arrays;

public class MyArrayListt {
	private int[] array;
	private int size;
	
	public MyArrayListt(int capacity) {
		array = new int[capacity];
		size = 0;
	}
	
	public MyArrayListt() {
		this(10);
	}
	
	/*
	// O(1)
	public void pushBack(int element) {
		array[size++] = element;
	}
	
	// O(1)
	public void popBack() {
		if (size == 0) {
			System.out.println("空的");
			return;
		}
		
		// --size;
		array[--size] = 0;
	}
	
	// O(n)
	public void pushFront(int element) {
		for (int i = size; i > 0; i--) {
			array[i] = array[i - 1];
		}
		array[0] = element;
		size++;
	}
	
	// O(n)
	public void popFront() {
		if (size == 0) {
			System.out.println("空的");
			return;
		}
		
		for (int i = 1; i < size; i++) {
			array[i - 1] = array[i];
		}
		
		array[--size] = 0;
	}
	*/
	
	// O(n)
	public void insert(int index, int element) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		boolean r = checkCapacity(1);
		if (!r) {
			ensureCapacity();
		}
	
		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}
		array[index] = element;
		size++;
	}
	
	// O(n)
	public void erase(int index) {
		if (size == 0) {
			System.out.println("空的");
			return;
		}
		
		for (int i = index + 1; i < size; i++) {
			array[i - 1] = array[i];
		}
		
		array[--size] = 0;
	}
	
	public void pushBack(int element) {
		insert(size, element);
	}
	
	public void pushFront(int element) {
		insert(0, element);
	}
	
	public void popBack() {
		erase(size - 1);
	}
	
	public void popFront() {
		erase(0);
	}
	
	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(array, size));
	}
	
	/**
	 * 待插入的数据个数
	 * @return true 表示够用，false 表示不够用
	 */
	private boolean checkCapacity(int num) {
		return size + num <= array.length;
	}
	
	// O(n)
	private void ensureCapacity() {
		// 策略：如果原来的 length 不够用，通常是扩大 2 倍
		
		int newLength = array.length * 2;
		int[] newArray = new int[newLength];
		for (int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
		
		array = newArray;	// this.array = newArray;
		//array = Arrays.copyOf(array, array.length * 2);
	}
	
	public int get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		return array[index];
	}
	
	public int set(int index, int element) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		int old = array[index];
		array[index] = element;
		return old;
	}
	
	public static void main(String[] args) {
		
		MyArrayListt list1 = new MyArrayListt();
		list1.pushBack(1);
		list1.pushBack(2);
		list1.pushBack(3);
	    list1.insert(3, 100);
		System.out.println(list1);

		MyArrayListt list2 = new MyArrayListt(2);
		list2.pushBack(1);
		list2.pushBack(2);
		System.out.println(list2.array.length);
		list2.pushBack(3);
		System.out.println(list2.array.length);
		list2.pushBack(4);
		System.out.println(list2.array.length);
		list2.pushBack(5);
		System.out.println(list2.array.length);
		list2.pushBack(6);
		list2.pushBack(7);
		System.out.println(list2.array.length);
	}
}