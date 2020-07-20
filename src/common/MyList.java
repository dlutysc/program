package common;

public class MyList {
    public ListNode head;
    public ListNode node1;
    public ListNode node2;
    public ListNode node3;

    public MyList(){
        head = new ListNode(1);
        node1 = new ListNode(2);
        node2 = new ListNode(3);
        node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
    }
}
