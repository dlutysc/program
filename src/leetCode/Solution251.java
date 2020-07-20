package leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 找到倒数第k个元素
 */
public class Solution251 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        Solution251 s = new Solution251();
        System.out.println(s.kThLargest(nums, 2));
        System.out.println(s.kThLargest1(nums, 2));
    }

    /**
     * 方法0
     * @param nums
     * @param k
     * @return
     */
    public int kThLargest(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 方法1 使用优先队列
     * @param nums
     * @param k
     * @return
     */
    public int kThLargest1(int[] nums, int k){
        Queue<Integer> que = new PriorityQueue<>();
        for (int val : nums){
            que.add(val);
            if (que.size() > k) {
                que.poll();
            }
        }
        return que.peek();
    }
}
