public class MyLinkedList {
	public static Node buildLinkedListHand() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		// 1 2 3 4 5
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		return n1;
	}
	
	public static void printLinkedList(Node head) {
		Node cur = head;
		
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
	//头插  O(1)
	public static Node pushFront(Node head, int val) {
		Node node = new Node(val);
		node.next = head;
		return node;
	}
	//头删 O(1)
	public static Node popFront(Node head) {
		if (head == null) {
			throw new RuntimeException("空链表");
		}
		
		return head.next;
	}
	//尾删 O(n)
	public static Node popBack(Node head){
		if(head==null){
			throw new RuntimeException("空的");
		}
		//链表中有一个节点
		if(head.next==null){
			return null;
		}else{
			Node cur =head;
			while(cur.next.next!=null){
				cur=cur.next;
			}
			cur.next=null;
			return head;
		}
	}
		//尾插 O(n)
	public static Node pushBack(Node head,int val){
			Node node=new Node(val);
			if(head==null){
				//链表中没有节点
				return node;
			}else{
				//链表中至少有一个节点
				
				Node cur=head;
				while(cur.next!=null){
					cur=cur.next;
				}
				//cur.next一定是null,即cur.next指向当前节点
				cur.next=node;
				return head;
		}
	}
	
	public static void main(String[] args) {
		/*
		Node head = buildLinkedListHand();
		// 按序打印每一个值
		// 1 2 3 4 5
		// 如何遍历链表
		printLinkedList(head);
		*/
		
		Node head = null;
		head = pushFront(head, 0);
		head = pushFront(head, 1);
		head = pushFront(head, 2);
		head = pushFront(head, 3);
		head = pushFront(head, 4);
		
		printLinkedList(head);
		
		head = popFront(head);
		head = popFront(head);
		
		printLinkedList(head);
		
		popBack(head);
		
		printLinkedList(head);
		
		pushBack(head,5);
		
		printLinkedList(head);
	}
}