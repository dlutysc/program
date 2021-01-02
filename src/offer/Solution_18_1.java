package offer;

import common.ListNode;
import common.MyList;

public class Solution_18_1 {
    public static void main(String[] args) {
        MyList myList = new MyList();
        ListNode delete = myList.node4;
        delNode(myList.head, delete);
        System.out.println(myList.toString());
    }
    public static void delNode(ListNode head, ListNode delete){
        // 不是尾节点
        if (delete.next != null){
            ListNode nxt = delete.next;
            delete.val = nxt.val;
            delete.next = nxt.next;
        }else if (delete == head){ // 只有一个节点
            head = null;
        }else { // 尾节点
            ListNode node = head;
            while (node.next != delete){
                node = node.next;
            }
            node.next = null;
        }
    }
}
