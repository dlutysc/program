package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 *       1
 *     /   \
 *    2     3
 *   / \   / \
 *  4   5 6   7
 */
public class Solution32_1 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Solution32_1 solution32 = new Solution32_1();
        System.out.println(solution32.printTree(node1));
    }

    public ArrayList<Integer> printTree(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
//        queue.remove();
        if (root == null){
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            if (queue.peek().left != null){
                queue.add(queue.peek().left);
            }
            if (queue.peek().right != null){
                queue.add(queue.peek().right);
            }
            res.add(queue.poll().val);
        }
        return res;
    }

    List<List<Integer>> printTree1(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return res;
        }
        queue.add(root);
        int curLine = 1;
        int nextLine = 0;
        while (!queue.isEmpty()) {
            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
                ++nextLine;
            }
            if (queue.peek().right != null){
                queue.add(queue.peek().right);
                ++nextLine;
            }
            --curLine;
            list.add(queue.poll().val);
            if (curLine == 0){
                curLine = nextLine;
                nextLine = 0;
                res.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return res;
    }
}
