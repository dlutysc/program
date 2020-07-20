package demo;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class DoTest {
    public static void main(String[] args) throws CloneNotSupportedException{
        int a = 10;
        double b = 3.14;
        int c = 5;
        System.out.println('A' + a + b);
        System.out.println(~a);
        System.out.println(c + ~a);

        int i= 1;
        System.out.println(i++);
        int j = i++;
        System.out.println(j);
        System.out.println(i);
        System.out.println("*************");
        int v0 = 1255;
        int v1 = 1255;
        System.out.println(v0 == v1);

        if (true & true) {
            System.out.println("1");
        }else {
            System.out.println("2");
        }
        System.out.println("################");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        List<ListNode> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        ListNode node = (ListNode) list.get(0).clone();
        node.val = 3;
        for (ListNode item : list){
            System.out.println(item.val);
        }
    }

}
