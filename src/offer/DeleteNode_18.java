package offer;
//class ListNode {
//    int val;
//    ListNode next = null;
//    ListNode(int val){
//        this.val = val;
//    }
//}


import common.ListNode;

/**
 * 剑指offer：删除链表中重复的节点
 */
public class DeleteNode_18 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = deleteDuplication(node1);
        System.out.println(node);
//        System.out.println(node.next.next);
    }

    public static ListNode deleteDuplication(ListNode head){
        if(head == null){
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != null){
            if(p1.val == p2.val){
                // 找到重复节点的结尾
                while(p2 != null && p1.val == p2.val){ //必须把p2 ！= null放到前边
                    p2 = p2.next;
                }
                ListNode start = p1; //start是重复节点开始处
                ListNode end = p2; //end是最后一个重复节点的下一个节点
                p1 = p2;       //更新p1和p2
                if(p2 != null){
                    p2 = p2.next;
                }
                // 去掉重复节点
                if(head == start){ //处理重复节点从头节点开始的情况
                    head = end;
                }else{             //重复节点开始处不在头节点
                    ListNode node = head;
                    while(node.next != start){
                        node = node.next;
                    }
                    node.next = end;
                }
            }else{
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return head;
    }
}
