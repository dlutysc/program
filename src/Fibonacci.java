import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            if (n == 1 || n == 2){
                System.out.println(1);
            }
            int[] a = new int[n];
            a[0] = 1;
            a[1] = 1;
            int temp1 = a[0];
            int temp2 = a[1];
            for (int i = 2; i < n; ++i){
                a[i] = temp1 + temp2;
                temp1 = temp2;
                temp2 = a[i];
            }
            System.out.println(a[n - 1]);
        }
    }
}
