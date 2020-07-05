package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  @Author chasein
 *  @Date 2020/7/5 15:56
 *  @Description 
 */
public class PrintTreePath1 {
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
        LinkedList<TreeNode> nodeStk = new LinkedList<>();
        LinkedList<String> pathStk = new LinkedList<>();
        nodeStk.add(root);
        String path = String.valueOf(root.val);
        pathStk.add(path);

        while (!nodeStk.isEmpty()){
            TreeNode node = nodeStk.pollLast();
            if (node.left == null && node.right == null){
                res.add(pathStk.pollLast());
            }else {
                String curPath = pathStk.pollLast();
                if (node.left != null){
                    nodeStk.add(node.left);
                    String newPath = curPath + "->" + node.left.val;
                    pathStk.add(newPath);
                }
                if (node.right != null) {
                    nodeStk.add(node.right);
                    String newPath = curPath + "->" + node.right.val;
                    pathStk.add(newPath);
                }
            }
        }

        return res;
    }
}
