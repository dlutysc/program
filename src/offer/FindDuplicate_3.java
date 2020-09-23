package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的元素
 * 找出数组中任意一个重复的数字
 */
public class FindDuplicate_3 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] array = {1, 2, 3, 4, 3, 5};
        int len = array.length;
        int[] duplication = new int[1];
        duplicate(array, len, duplication);
        System.out.println(Arrays.toString(duplication));

        int[] arr1 = {4, 3, 2, 2, 1};
        int length = arr1.length;
        duplicate1(arr1, length, duplication);
        System.out.println(Arrays.toString(duplication));
    }

    /**
     * 方法0
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate(int[] numbers, int length, int[] duplication){
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            // 旧写法
//            if (map.get(numbers[i]) != null) {
//                int val = map.get(numbers[i]);
//                map.put(numbers[i], ++val);
//            }else {
//                map.put(numbers[i], 1);
//            }

            int value = map.getOrDefault(numbers[i], 0);
            map.put(numbers[i], ++value);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > 1){
                duplication[0] = entry.getKey();
                return true;
            }
        }

        return false;
    }

    /**
     * 方法1
     * @param nums
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate1(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
