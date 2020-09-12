package offer;

import common.ListNode;
import common.MyList;
/**
 *  @Author chasein
 *  @Date 2020/9/12 14:28
 *  @Description 删除链表中重复的节点
 */
public class Solution18_2 {
    public static void main(String[] args) {
        MyList myList = new MyList();
        System.out.println(myList.toString());
        deleteDuplication(myList.head);
        System.out.println(myList.toString());
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        ListNode preNode = null;
        ListNode node = pHead;
        while (node != null) {
            ListNode nxt = node.next;
            boolean needDelete = false;
            if (nxt != null && nxt.val == node.val) {
                needDelete = true;
            }
            if (!needDelete) {
                preNode = node;
                node = node.next;
            } else {
                int value = node.val;
                ListNode toBeDel = node;
                while (toBeDel != null && toBeDel.val == value) {
                    nxt = toBeDel.next;
                    toBeDel = nxt;
                }
                if (preNode == null) {
                    pHead = nxt;
                } else {
                    preNode.next = nxt;
                }
                node = nxt;
            }
        }
        return pHead;
    }
}


