package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NextNodeInTree_8 {
    public static void main(String[] args) throws Exception{
        TreeNode root =  ReConstructTree_7.constructTree(ReConstructTree_7.preOrder, ReConstructTree_7.inOrder);
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        System.out.println(res);
    }

    static void inOrder(TreeNode root, List res){
        if (root != null){
            inOrder(root.left, res);
            res.add(root.val);
            inOrder(root.right, res);
        }
    }
}
