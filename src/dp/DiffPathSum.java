package dp;

import java.util.Arrays;

/**
 *  @Author chasein
 *  @Date 2020/7/26 16:45
 *  @Description leetcode 62 不同路径
 */
public class DiffPathSum {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
    }

    public static int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        for (int[] a : dp){
            System.out.println(Arrays.toString(a));
        }
        return dp[m - 1][n - 1];
    }
}
