package dp.matrix_path;


import java.util.Arrays;

/**
 *  @Author chasein
 *  @Date 2020/7/26 11:18
 *  @Description leetcode 64 最小路径和
 */
public class Solution64 {
    public static void main(String[] args) {
//        int[][] grid = {
////                {1, 3, 1},
////                {1, 5, 1},
////                {4, 2, 1}
////        };
        int[][] grid = {
                {1, 2, 5},
                {3, 2, 1}
        };
        Solution64 solution64 = new Solution64();
        System.out.println(solution64.minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < cols; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        for (int[] a : dp){
            System.out.println(Arrays.toString(a));
        }
        return dp[rows - 1][cols - 1];
    }
}
