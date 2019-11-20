//删除链表中指定的val值
public class DeleteVal1{
	public static Node buildLinkedListHand() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(3);
		Node n5 = new Node(5);
		// 1 2 3 3 5
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
	
	
	public static Node Delete(Node head,int val){
		Node prev=null;
		Node cur=head;
		while(cur!=null){
			if(cur.val==val){
				if(head.val==val){
					head=head.next;
				}else{
					prev.next=cur.next;
				}
			}else{
				prev=cur;
			}
			cur=cur.next;
					
			}
			return head;
		}
	public static void main(String[] args){
		Node head=buildLinkedListHand();
		Delete(head,3);
		printLinkedList(head);
	}
}