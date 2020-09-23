package offer;

import common.TreeNode;
/**
 *  @Author chasein
 *  @Date 2020/9/12 15:55
 *  @Description 二叉树的深度
 *  *
 *  *       1
 *  *     /   \
 *  *    2     3
 *  *   /     / \
 *  *  4     5   6
 */
public class Solution_38 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        System.out.println(treeDepth(node1));
    }

    public static int treeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
