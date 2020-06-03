package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 之字形打印二叉树
 *        1
 *      /   \
 *     2     3
 *    / \   / \
 *   4   5 6   7
 *  / \
 * 8   9
 */
public class Solution32_3 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        Solution32_3 solution32 = new Solution32_3();
        System.out.println(solution32.printTree(node1));
    }

    public ArrayList<ArrayList<Integer>> printTree(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack0 = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        if (root == null){
            return res;
        }
        int dir = 1; //0代表从左向右打印,1代表从右向左打印
        int curLine = 1;
        int nextLine = 0;
        stack0.push(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack0.isEmpty() || !stack1.isEmpty()){
            if (dir == 1){
                if (stack0.peek().left != null){
                    stack1.push(stack0.peek().left);
                    nextLine++;
                }
                if (stack0.peek().right != null){
                    stack1.push(stack0.peek().right);
                    nextLine++;
                }
            }else {
                if (stack1.peek().right != null){
                    stack0.push(stack1.peek().right);
                    nextLine++;
                }
                if (stack1.peek().left != null){
                    stack0.push(stack1.peek().left);
                    nextLine++;
                }
            }

            if (dir == 1){
                list.add(stack0.pop().val);
            }else {
                list.add(stack1.pop().val);
            }

            curLine--;
            if (curLine == 0){
                curLine = nextLine;
                nextLine = 0;
                dir = (dir == 0 ? 1 : 0);
                res.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return res;
    }
}

