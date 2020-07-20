package huawei.online_test;

import java.util.*;

/**
 * 头条实习笔试
 */
//class huawei.online_test.ListNode{
//    int val;
//    huawei.online_test.ListNode next = null;
//    huawei.online_test.ListNode(int val){
//        this.val = val;
//    }
//}
public class PlusAB {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        System.out.println(plusAB(node1, node3).val);
    }
    public static ListNode plusAB(ListNode a, ListNode b) {
        if(a == null || b == null){
            return a == null ? b : a;
        }
        ListNode node1 = a;
        int base1 = 1;
        int sum1 = 0;
        while(node1 != null){
            sum1 += base1 * node1.val;
            base1 = base1 * 10;
            node1 = node1.next;
        }
        ListNode node2 = b;
        int base2 = 1;
        int sum2 = 0;
        while(node2 != null){
            sum2 += base2 * node2.val;
            base2 = base2 * 10;
            node2 = node2.next;
        }
        int sum = sum1 + sum2;
        int len = String.valueOf(sum).length();
        int[] digits = getDigits(len + 1, sum);
        List<ListNode> list = new ArrayList<>();
        for(int i = 1; i < digits.length; ++i){
            list.add(new ListNode(digits[i]));
        }
        int i;
        for( i = 0; i < list.size() - 1; ++i){
            list.get(i).next = list.get(i + 1);
        }
        list.get(i).next = null;
        return list.get(0);
    }
    public static int[] getDigits(int n, int num){
        int[] digits = new int[n];
        digits[0] = 0;
        int i = 1;
        while (i <= n - 1){
            digits[i] = (num % 10);
            num = num / 10;
            ++i;
        }
        return digits;
    }
}
