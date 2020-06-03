import java.util.Scanner;

/**
 * 华为机试：从单向链表中删除指定值的节点
 */
class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}
public class DeleteListNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int len = sc.nextInt();
            int headVal = sc.nextInt();
            ListNode head = new ListNode(headVal);
            for (int i = 0; i < len - 1; i++) {
                int val1 = sc.nextInt();
                int val2 = sc.nextInt();
                insert(head, val1, val2);
            }
            int delVal = sc.nextInt();
            head = delete(head, delVal);
            ListNode node = head;
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
        }
        sc.close();

    }

    static void insert(ListNode head, int val1, int val2){
        ListNode node1 = new ListNode(val1); //要插入的节点
        ListNode node = head;
        while (node != null && node.val != val2) {
            node = node.next;
        }

        ListNode temp = node.next;
        node.next = node1;
        node1.next = temp;
    }

    static ListNode delete(ListNode head, int del){
        ListNode node = head;
        if (head.val == del) {
            head = head.next;
        }else {
            while (node.next != null && node.next.val != del){
                node = node.next;
            }
            ListNode preNode = node;
            ListNode delNode = preNode.next;
            ListNode temp = delNode.next;
            preNode.next = temp;
        }
        return head;
    }
}
