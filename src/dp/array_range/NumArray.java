package dp.array_range;

import java.util.Arrays;

/**
 *  @Author chasein
 *  @Date 2020/7/28 14:10
 *  @Description leetcode 303 区域和检索-数组不可变
 */
public class NumArray {
    int[] nums;
    int[] sum;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.sum = new int[nums.length];
        int pre = 0;
        for (int i = 0; i < sum.length; i++) {
            sum[i] = nums[i] + pre;
            pre = sum[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return sum[j];
        return sum[j] - sum[i - 1];
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 3, -5, 5};
        NumArray obj = new NumArray(nums);
        System.out.println(Arrays.toString(obj.sum));
        System.out.println(obj.sumRange(2, 4));
        System.out.println(obj.sumRange(0, 3));
    }
}


