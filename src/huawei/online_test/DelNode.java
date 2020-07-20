package huawei.online_test;

import java.util.ArrayList;
import java.util.Scanner;

public class DelNode {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while (sc.hasNext()) {
            int len = sc.nextInt();
            int head = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(head);
            for (int i = 0; i < len - 1; i++) {
                int node1 = sc.nextInt();
                int node2 = sc.nextInt();
                int index = list.indexOf(node2);
                list.add(index + 1, node1);
            }
            int delNode = sc.nextInt();
            list.remove((Object)delNode);
            for (int i = 0; i < list.size(); i++) {
                if (i != list.size() - 1){
                    System.out.print(list.get(i) + " ");
                }else {
                    System.out.println(list.get(i) + "\n");
                }
            }
            System.out.println(list.indexOf(4));
        }
    }
}
