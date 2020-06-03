import java.util.Scanner;

/**
 * 华为机试：计算字符串间的距离
 */
public class EditString {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while (sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            int ic = 1;
            int dc = 1;
            int rc = 1;
            int cost = editCost(str1, str2, ic, dc, rc);
            System.out.println(cost);
        }

    }

    static int editCost(String str1, String str2, int ic, int dc, int rc){
        int rows = str1.length();
        int cols = str2.length();
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i <=cols; i++) {
            dp[0][i] = i * ic;
        }
        for (int i = 1; i <= rows; i++) {
            dp[i][0] = i * dc;
        }
        for (int i = 1; i <= rows ; i++) {
            for (int j = 1; j <= cols; j++) {
                int cost1 = dp[i - 1][j] + dc;
                int cost2 = dp[i][j - 1] + ic;
                int cost3;
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    cost3 = dp[i - 1][j - 1];
                }else {
                    cost3 = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(Math.min(cost1, cost2), cost3);
            }
        }
        return dp[rows][cols];
    }
}
