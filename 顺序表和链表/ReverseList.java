public class ReverseList{
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
	public static Node ReverseList1(Node head){
		Node nhead=null;
		Node cur=head;
	while(cur!=null){
		Node next=cur.next;
		
		cur.next=nhead;
		nhead=cur;
		
		cur=next;
	}	
	return nhead;	
	}
	public static Node ReverseList2(Node head){
		Node p1=null;
		Node p2=head;
		while(p2!=null){
			Node p3=p2.next;
			p2.next=p1;
			p1=p2;
			p2=p3;
		}
	return p1;
	}
	public static void main(String[] args){
		Node head= buildLinkedListHand();
		head=ReverseList1(head);
		
		printLinkedList(head);
		
		head=ReverseList2(head);
		printLinkedList(head);
	}
}