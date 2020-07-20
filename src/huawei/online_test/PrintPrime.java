package huawei.online_test;

import java.util.ArrayList;

public class PrintPrime {
    public static void main(String[] args) {
        prime(1000);
    }

    static void prime(int num){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        for (int i = 3; i <= num; i += 2) {
            boolean flag = true;
            for (int j = 0; list.get(j) <= Math.sqrt(i); j++) {
                if (i % list.get(j) == 0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                list.add(i);
            }
        }
        System.out.println(list);
        System.out.println(list.size());
    }
}
