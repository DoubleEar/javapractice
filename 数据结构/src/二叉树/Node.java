package 二叉树;

//二叉链
class Node {
    int value;
    Node left;
    Node right;
    char val;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
    public Node(char value) {
        this.val = value;
    }
}
