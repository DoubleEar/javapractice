package AVL树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AVLTree {
    //记录树的根结点，如果是空树，则 root == null
    private Node root=null;

    /**
     * 插入AVL树
     * @param key 要插入的关键字
     * @throws RuntimeException key重复时
     */
    public void insert(int key){
        if(root==null) {
            //空树的插入
            root = new Node(key, null);
            return;
        }

        //不为空树
        Node parent=null;
        Node cur=root;

        while (cur!=null){
            if(cur.key==key)
                throw new RuntimeException("key("+key+")值相同，插入失败");
            else if(key>cur.key) {
                parent=cur;
                cur = cur.right;
            }else {
                parent=cur;
                cur = cur.left;
            }
        }

        //直到找到null，才开始真正的插入。
        if(key<parent.key)
            cur=parent.left=new Node(key,parent);
        else    //不可能出现等于的情况
            cur=parent.right=new Node(key,parent);


        //上面是正常搜索树的插入
        //parent是要调整BF的节点
        //cur是破坏源所在的根节点
        while (true){
            //根据情况，更新平衡因子
            if(cur==parent.left)
                parent.bf++;
            else
                //cur==parent.right
                parent.bf--;

            //分情况处理
            if(parent.bf==0){
                break;
            }else if(parent.bf==2){
                //进行失衡的修复
                //左左失衡，左右失衡
                if(cur.bf==1){
                    //左左失衡
                    fixLeftLeftLoseBalance(parent);
                }else{
                    //-1
                    //左右失衡
                    fixLeftRightLoseBalance(parent);
                }
                break;
            }else if(parent.bf==-2){
                //进行失衡的修复
                //右右失衡，右左失衡
                if(cur.bf==-1){
                    //右右失衡
                    fixRightRightLoseBalance(parent);
                }else {
                    //1
                    //右左失衡
                    fixRightLeftLoseBalance(parent);
                }
                break;
            }else if(parent==root){
                break;
            }

            //如果需要继续->平衡因子为1/-1的情况
            Node parentOfParent=parent.parent;
            cur=parent;
            parent=parentOfParent;
        }
    }

    //左旋
    private void leftRotation(Node parent){
        //要进行左旋，parent一定不为空，并且它的右孩子一定不为空。
        Node parentOfParent=parent.parent;
        Node right=parent.right;
        Node leftOfRight=right.left;

        right.parent=parentOfParent;
        //需要明确原来parent是parentOfParent的的左孩子还是右孩子
        if(parentOfParent==null)
            root=right;     //如果parent是原来的根，那么现在需要修改为right
        else if(parent==parentOfParent.left)
            parentOfParent.left=right;
        else
            parentOfParent.right=right;

        right.left=parent;
        parent.parent=right;

        parent.right=leftOfRight;
        if(leftOfRight!=null) {
            leftOfRight.parent = parent;
        }
    }

    //右旋
    private void rightRotation(Node parent){
        //要进行左旋，parent一定不为空，并且它的左孩子一定不为空。
        Node parentOfParent=parent.parent;
        Node left=parent.left;
        Node rightOfLeft=left.right;

        left.parent=parentOfParent;
        if(parentOfParent==null)
            root=left;
        else if(parent==parentOfParent.left)
            parentOfParent.left=left;
        else
            parentOfParent.right=left;

        left.right=parent;
        parent.parent=left;

        parent.left=rightOfLeft;
        if(rightOfLeft!=null){
            rightOfLeft.parent=parent;
        }
    }

    //调节左左失衡
    private void fixLeftLeftLoseBalance(Node parent) {
        //左左失衡，对失衡节点进行右旋
        Node leftOfNode=parent.left;
        rightRotation(parent);

        //根据计算的结果，更新BF
        parent.bf=leftOfNode.bf=0;
    }

    //调节左右失衡
    private void fixLeftRightLoseBalance(Node parent) {
        //出现失衡，一定不会出现null
        Node leftOfParent=parent.left;
        Node rOfLeftOfParent=leftOfParent.right;

        //先对左孩子进行左旋
        leftRotation(leftOfParent);
        //在对失衡节点进行右旋
        rightRotation(parent);

        //根据计算的结果，更新BF
        if(rOfLeftOfParent.bf==1){
            parent.bf=-1;
            leftOfParent.bf=0;
            rOfLeftOfParent.bf=0;
        }else if(rOfLeftOfParent.bf==-1){
            parent.bf=0;
            leftOfParent.bf=1;
            rOfLeftOfParent.bf=0;
        }else{
            parent.bf=leftOfParent.bf=rOfLeftOfParent.bf=0;
        }
    }

    //调节右右失衡
    private void fixRightRightLoseBalance(Node parent) {
        //右右失衡，对失衡节点进行左旋
        Node rightOfParent=parent.right;
        leftRotation(parent);

        //根据计算的结果，更新BF
        parent.bf=rightOfParent.bf=0;
    }

    //调节右左失衡
    private void fixRightLeftLoseBalance(Node parent) {
        //出现失衡，一定不会出现null
        Node rightOfParent=parent.right;
        Node lOfRightOfParent=rightOfParent.left;

        //先对右孩子进行右旋
        rightRotation(rightOfParent);
        //在对失衡节点进行左旋
        leftRotation(parent);

        //根据计算的结果，更新BF
        if(lOfRightOfParent.bf==1){
            parent.bf=0;
            rightOfParent.bf=-1;
            lOfRightOfParent.bf=0;
        }else if(lOfRightOfParent.bf==-1){
            parent.bf=1;
            rightOfParent.bf=0;
            lOfRightOfParent.bf=0;
        }else{
            parent.bf=rightOfParent.bf=lOfRightOfParent.bf=0;
        }
    }

    /**
     * 在AVL树中查找是否包含key
     * @param key 要查找的关键字
     * @return  AVL树中是否包含这个key
     */
    public boolean contains(int key){
        Node cur=root;

        while (cur!=null){
            if(cur.key==key)
                return true;
            else if(key>cur.key)
                cur=cur.right;
            else
                cur=cur.left;
        }

        return false;
    }

    //验证AVL树
    public void verify() {
        //计算该树的中序遍历
        List<Integer> inOrderList=new ArrayList<>();
        inOrder(inOrderList,root);
        //判断有序：把inOrder与排序后的inOrderList进行对比
        List<Integer> copyList=new ArrayList<>(inOrderList);
        Collections.sort(copyList);

        if(!copyList.equals(inOrderList)){
            throw new RuntimeException("AVL是不满足规则：中序遍历无序");
        }
        System.out.println("中序遍历有序，验证成功！");

        //验证每个节点的BF计算是否正确
        preOrderAndCal(root);
        System.out.println("BF计算正确，验证成功！");

        //验证每个节点的BF是否为（-1，1，0）
        perOrderAnaVerifyBF(root);
        System.out.println("BF满足AVL特性，验证成功！");
    }

    private static void perOrderAnaVerifyBF(Node node) {
        if(node!=null) {
            if (node.bf != 1 && node.bf != 0 && node.bf != -1)
                throw new RuntimeException("节点（" + node.key + ")的BF是" + node.bf);

            perOrderAnaVerifyBF(node.left);
            perOrderAnaVerifyBF(node.right);
        }
    }

    //计算一棵树的高度
    private static int getHeight(Node node){
        if(node==null)
            return 0;
        int left=getHeight(node.left);
        int right=getHeight(node.right);
        return Math.max(left,right)+1;
    }

    private static void preOrderAndCal(Node node){
        if(node!=null) {
            int left = getHeight(node.left);
            int right = getHeight(node.right);
            if (left - right != node.bf)
                throw new RuntimeException("节点(" + node.key + ")的BF计算有错");

            preOrderAndCal(node.left);
            preOrderAndCal(node.right);
        }
    }

    private static void inOrder(List<Integer> inOrderList,Node node){
        if(node!=null){
            inOrder(inOrderList,node.left);
            inOrderList.add(node.key);
            inOrder(inOrderList,node.right);
        }
    }
}
