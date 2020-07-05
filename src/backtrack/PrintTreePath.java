package backtrack;

import java.util.ArrayList;
import java.util.List;
/**
 *  @Author chasein
 *  @Date 2020/7/5 15:55
 *  @Description 
 */
class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int x) {
        val = x;
    }
}

public class PrintTreePath {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        System.out.println(printPath(node1));
    }

    public static List<String> printPath(TreeNode root){
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        find(root, res, new StringBuilder());
        return res;
    }

    public static void find(TreeNode node, List<String> res, StringBuilder temp){
        if (node != null){
            temp.append(node.val);
            if (node.left == null && node.right == null){
                res.add(temp.toString());
            }else {
                temp.append("->");
                find(node.left, res, new StringBuilder(temp));
                find(node.right, res, new StringBuilder(temp));
            }
        }
    }
}
