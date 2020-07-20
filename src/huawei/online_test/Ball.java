package huawei.online_test;

import java.util.Scanner;

public class Ball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int high = sc.nextInt();
            System.out.println(getJourney(high));
            System.out.println(getFifthHigh(high));
        }
    }

    public static double getJourney(int high){
        double distance = high;
        double h = high;
        for (int i = 0; i < 4; i++) {
            h = h / 2;
            distance += 2 * h;
        }

        return distance;
    }

    public static double getFifthHigh(int high){
        double res = high;
        for (int i = 0; i < 5; i++) {
            res = res / 2;
        }

        return res;
    }

}
