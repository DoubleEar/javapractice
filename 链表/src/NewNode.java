public class NewNode {
    int val;
    NewNode next;
    NewNode random;
    NewNode(){

    }
    NewNode(int val,NewNode next,NewNode random){
        this.val=val;
        this.next=next;
        this.random=random;
    }
    NewNode(int val){
        this(val,null,null);
    }

}
