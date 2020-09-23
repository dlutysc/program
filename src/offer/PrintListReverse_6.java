package offer;

import common.ListNode;
import common.MyList;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListReverse_6 {
    public static void main(String[] args) {
        MyList list = new MyList();
        System.out.println(printReverse(list.head));
        printReverse1(list.head);
        System.out.println();
        System.out.println(printReverse2(list.head));
        System.out.println(printReverse3(list.head));
        System.out.println("方法4 " + printReverse4(list.head));
    }

    /**
     * 方法0,使用栈
     * @param head
     * @return
     */
    public static ArrayList<Integer> printReverse(ListNode head){
        ArrayList<Integer> list = new ArrayList<>();
        if (head == null) {
            return list;
        }
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        while (node != null){
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 方法1 该方法只是将结果输出，而不返回值
     * @param head
     * @return
     */
    public static void printReverse1(ListNode head){
        if (head != null) {
            printReverse1(head.next);
            System.out.print(head.val + " ");
        }
    }

    /**
     * 方法2
     * @param head
     * @return
     */
    public static ArrayList<Integer> printReverse2(ListNode head){
        ArrayList<Integer> ret = new ArrayList<>();
        if (head != null) {
            ret.addAll(printReverse2(head.next));
            ret.add(head.val);
        }
        return ret;
    }

    /**
     * 方法3
     * @param head
     * @return
     */
    private static ArrayList<Integer> ret = new ArrayList<>();
    public static ArrayList<Integer> printReverse3(ListNode head){
        print(head);
        return ret;
    }
    private static void print(ListNode head){
        if (head != null) {
            print(head.next);
            ret.add(head.val);
        }
    }

    /**头插法
     * 方法4
     */
    public static ArrayList<Integer> printReverse4(ListNode head){
        ArrayList<Integer> ret = new ArrayList<>();
        if (head == null) {
            return ret;
        }
        ListNode memo = new ListNode(-1);
        ListNode node = head;
        while (node != null) {
            ListNode newNode = new ListNode(node.val);
            newNode.next = memo.next;
            memo.next = newNode;
            node = node.next;
        }
        //整理输出结果
        ListNode newHead = memo.next;
        while (newHead != null) {
            ret.add(newHead.val);
            newHead = newHead.next;
        }
        return ret;
    }
}
