package common;


public class MyList extends Object{
    public ListNode head;
    public ListNode node1;
    public ListNode node2;
    public ListNode node3;
    public ListNode node4;

    public MyList(){
        head = new ListNode(1);
        node1 = new ListNode(2);
        node2 = new ListNode(3);
        node3 = new ListNode(3);
        node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = head;
        while (node != null) {
            sb.append(node.val);
            if (node.next != null){
                sb.append("-");
            }
            node = node.next;
        }
        return sb.toString();
    }
}
