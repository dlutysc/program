package offer;

import common.TreeNode;
import java.util.List;
/**
 *  @Author chasein
 *  @Date 2020/12/30 11:09
 *  @Description 重建二叉树
 *  只通过了这个例子，还没有在牛客上进行测试
 */
public class ReConstructTree_7 {
    static int[] preOrder = {1, 2 ,4, 7, 3, 5, 6, 8};
    static int[] inOrder = {4 ,7, 2, 1, 5, 3 , 8, 6};

    public static void main(String[] args) throws Exception{
        TreeNode root = constructTree(preOrder, inOrder);
        Solution32_1 print = new Solution32_1();
        List list = print.printTree(root);
        System.out.println(list);
    }
    public static TreeNode constructTree(int[] preOrder, int[] inOrder) throws Exception{
        if (preOrder == null || inOrder == null){
            return null;
        }
        int inOrderLen = inOrder.length;
        return constructTreeCore(0, 0, inOrderLen - 1);
    }

    static TreeNode constructTreeCore(int preOrderStart, int inOrderStart, int inOrderEnd) throws Exception{
        TreeNode root = new TreeNode();
        root.val = preOrder[preOrderStart];
        root.left = root.right = null;
        int v = preOrder[preOrderStart];
        int inOrderRootIdx = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == v) {
                inOrderRootIdx = i;
            }
        }
        if (inOrderRootIdx == inOrder.length){
            throw new  Exception("");
        }
        int leftLength = inOrderRootIdx - inOrderStart; // 左子树长度
        int rightLength = inOrderEnd - inOrderRootIdx; // 右子树长度
        if (leftLength > 0){
            root.left = constructTreeCore(preOrderStart + 1,
                    inOrderRootIdx - leftLength,
                    inOrderRootIdx - 1);
        }
        if (rightLength > 0){
            root.right = constructTreeCore(preOrderStart + leftLength + 1,
                    inOrderRootIdx + 1, inOrderRootIdx + rightLength);
        }
        return root;
    }
}
