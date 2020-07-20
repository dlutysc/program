package huawei.online_test;

import java.util.Scanner;

public class SnakeMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int row = 1;
            int in = sc.nextInt();
            int num = in;
            while (row < in){
                int step = row + 1;
                int count = num;
                int prev = row * (row - 1) / 2 + 1;
                System.out.print(prev + " ");
                while (count > 1){
                    prev = prev  + step;
                    System.out.print(prev);
                    if (count > 2){
                        System.out.print(" ");
                    }
                    count--;
                    step++;
                }
                System.out.print("\n");
                --num;
                ++row;
            }
            System.out.println(row * (row - 1) / 2 + 1);
        }

    }
}
