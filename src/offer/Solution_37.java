package offer;

import common.TreeNode;

/**
 * 序列化二叉树
 *       1
 *     /   \
 *    2     3
 *   /     / \
 *  4     5   6
 */
public class Solution_37 {
    static int index = -1;
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

        String ret = serialize(node1);
        String ans = ret.substring(0, ret.lastIndexOf(','));
        System.out.println(ans);

        TreeNode node = deSerialize("1,2,4,$,$,$,3,5,$,$,6,$,$");
        System.out.println(print(node));

    }
    static StringBuilder sb = new StringBuilder();
    static String print(TreeNode node){
        if (node != null){
            sb.append(node.val + " ");
            print(node.left);
            print(node.right);
        }
        return sb.toString();
    }

    static String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("$,");
            return sb.toString();
        }
        sb.append(root.val + ","); //不能加‘,’
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }
    static TreeNode deSerialize(String str) {
        String[] strs = str.split(",");
        return ds(strs);
    }
    // index 须是全局变量
    static TreeNode ds(String[] strs){
        ++index;
        if (index >= strs.length) {
            return null;
        }
        TreeNode node = null;
        if (!strs[index].equals("$")){
            node = new TreeNode(Integer.parseInt(strs[index]));
            node.left = ds(strs);
            node.right = ds(strs);
        }
        return node;
    }

    static TreeNode deSerialize1(String str) {
        index++;
        if (index >= str.length()) {
            return null;
        }
        String[] strs = str.split(",");
        TreeNode node = null;
        if (!strs[index].equals("$")){
            node = new TreeNode(Integer.parseInt(strs[index]));
            node.left = deSerialize1(str);
            node.right = deSerialize1(str);
        }
        return node;
    }
}
