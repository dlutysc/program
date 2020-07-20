package huawei.online_test;

import java.util.ArrayList;
import java.util.Scanner;

public class RabbitNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int month = sc.nextInt();
            int res = 1;
            int mark = 1;
            if (month < 3){
                System.out.println(1);
            }
            System.out.println(getNum(mark, month, res));
        }

    }

    public static int getNum(int mark, int month, int res){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = mark + 2; i <= month; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); ++i){
            if (list.get(i) <= month -2){
                res += getNum(list.get(i), month, res);
            }
        }
        return res;
    }
}
