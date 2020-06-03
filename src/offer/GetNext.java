package offer;

class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode next = null;
    TreeNode(int val){
        this.val = val;
    }
}
/**
 * 剑指offer：二叉树的下一个节点
 */
public class GetNext {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
//        node1.left = node2;
//        node1.right = node5;
//        node2.left = node3;
//        node2.right = node4;
//        node2.next = node1;
//        node3.next = node2;
//        node4.next = node2;
//        node4.left = node6;
//        node4.right = node7;
//        node5.next = node1;
//        node5.right = node8;
//        node6.next = node4;
//        node7.next = node4;
//        node8.next = node5;
        TreeNode nextNode = getNext(node5);
        System.out.println(nextNode);
    }

    public static TreeNode getNext(TreeNode node){
        if(node == null){
            return null;
        }
        TreeNode temp = node.right;
        TreeNode nextNode;
        //如果一个节点有右子树
        if(temp != null){
            while(temp.left != null){
                temp = temp.left;
            }
            nextNode = temp;
        }
        //如果一个节点没有右子树，且是它父节点的左子节点
        else if(node.right == null && node.next != null && node.next.left == node){
            nextNode = node.next;
        }else { //没有右子树，并且还是其父节点的右子节点
            temp = node.next;
            while(temp != null && temp.next != null && temp.next.left != temp){
                temp = temp.next;
            }
            //注意要判断temp != null,如果只有一个节点时temp=null,直接temp.next会出现NullPointerException
            if(temp != null && temp.next != null){
                nextNode = temp.next;
            }else{
                nextNode = null;
            }
        }
        return nextNode;
    }
}
