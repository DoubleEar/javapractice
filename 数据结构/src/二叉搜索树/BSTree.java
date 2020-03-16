package 二叉搜索树;

public class BSTree {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root = null;

    //查找
    public Node find(int val) {
        if (root == null)
            return null;
        Node cur = root;
        //从根开始搜索
        while (cur != null) {
            if (cur.value == val)
                return cur;
            else if (cur.value > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    //插入
    //新的节点都是插入在叶子节点上或不完全二叉树上。
    public boolean insert(int val) {
        if (root == null) {
            root = new Node(val);
            return true;
        }
        //非空，首先搜索（值不能重复），在插入。
        Node cur = root;
        Node parent = null;
        //找到要插入的位置时，cur为null，就跳出循环。
        while (cur != null) {
            parent = cur;
            if (cur.value == val)
                //不能插入重复的节点。
                return false;
            else if (cur.value > val) {
                cur = cur.left;
            } else
                cur = cur.right;
        }
        //找到一个合适的位置
        cur = new Node(val);
        if (parent.value > cur.value)
            parent.left = cur;
        else
            parent.right = cur;
        return true;
    }

    public void inOrder() {
        inOrderInternal(root);
        System.out.println();
    }

    //中序遍历
    public void inOrderInternal(Node root) {
        if (root != null) {
            inOrderInternal(root.left);
            System.out.print(root.value + " ");
            inOrderInternal(root.right);
        }
    }

    public boolean remove(int value) {
        if (root == null)
            return false;
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (cur.value == value)
                break;
            else if (cur.value > value) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        //判断节点是否存在
        if (cur == null)
            return false;
        remove(parent, cur);
        return true;
    }

    public void remove(Node parent, Node cur) {
        if (cur.left == null) {
            if (cur != root) {
                if (parent.left == cur) {
                    parent.left = cur.right;
                } else
                    parent.right = cur.left;
                //cur为root
            } else
                //单边树
                root = cur.right;
        } else if (cur.right == null) {
            if (cur != root) {
                if (parent.left == cur) {
                    parent.left = cur.left;
                } else
                    parent.right = cur.left;
            //cur为root
            } else
                //单边树
                root = cur.left;
        } else {
            //左右子树都存在
            //1.找到左子树的最右节点
            //2.或者找到右子树的最左节点
            //1.
            parent = cur;
            Node next = cur.left;
            //找到最右节点
            while (next.right != null) {
                parent = next;
                next = next.right;
            }
            //把最右节点next的值赋给cur
            cur.value = next.value;
            //删除next
            //next为最右节点，则next一定没有右孩子。
            if (parent.left == next)
                parent.left = next.left;
            else
                parent.right = next.left;
        }
    }
}
    class Test{
        public static void main(String[] args) {
            BSTree bst=new BSTree();

            bst.insert(10);
            bst.insert(1);
            bst.insert(0);
            bst.insert(15);
            bst.insert(2);
            bst.insert(4);
            bst.insert(7);

            bst.inOrder();

            bst.remove(7);
            bst.inOrder();

            bst.remove(2);
            bst.inOrder();

            bst.remove(10);
            bst.inOrder();
        }
    }


