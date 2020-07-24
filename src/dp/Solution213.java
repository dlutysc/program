package dp;
/**
 *  @Author chasein
 *  @Date 2020/7/23 15:06
 *  @Description 打家劫舍 II
 */
public class Solution213 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 第一家和最后一家只能抢一家
        // 抢第一家
        int pre1 = 0, pre2 = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if(i != nums.length - 1){
                int cur = Math.max(pre1, nums[i] + pre2);
                pre2 = pre1;
                pre1 = cur;
            }
        }
        int max1 = pre1;
        // 抢最后一家
        pre2 = 0;
        pre1 = 0;
        for (int i = 1; i < nums.length; ++i) {
            int cur = Math.max(pre1, nums[i] + pre2);
            pre2 = pre1;
            pre1 = cur;
        }
        int max2 = pre1;
        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        Solution213 s = new Solution213();
        int[] a = {2, 3, 2};
        int[] a1 = {1, 2, 3, 1};
        System.out.println(s.rob(a));
        System.out.println(s.rob(a1));
    }
}
