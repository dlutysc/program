package dp.array_range;
/**
 *  @Author chasein
 *  @Date 2020/9/6 17:28
 *  @Description 数组中中等差递增子区间的个数
 */
public class Solution413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0) return 0;
        int len = A.length;
        int[] dp = new int[len];
        for (int i = 2; i < len; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
                dp[i] = dp[i - 1] + 1;
            }
        }
        int sum = 0;
        for (int n : dp){
            sum += n;
        }
        return sum;
    }
}
