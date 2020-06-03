package offer;

import java.util.Scanner;

/**
 *连续子数组最大和
 */
public class MaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            int maxSum = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (sum > maxSum) {
                    maxSum = sum;
                }
                if (sum < 0) { //两个if的判断顺序不能颠倒
                    sum = 0;
                }
            }
            System.out.println(maxSum);
        }
    }
}
