package dp;

import java.util.Scanner;

public class SendEmail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(count(n));
        }
    }

    public static long count(int n){
        if (n == 1) {
            return 0;
        }
        if (n == 2){
            return 1;
        }
        long pre1 = 1, pre2 = 0;
        for (int i = 3; i <= n; ++i){
            long cur = (i - 1) * (pre1 + pre2);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
