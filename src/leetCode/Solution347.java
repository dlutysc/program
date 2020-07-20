package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : nums){
            if (map.get(key) != null) {
                int val = map.get(key);
                ++val;
                map.put(key, val);
            }else {
                map.put(key, 1);
            }
        }
        List<Integer>[] lists = new List[nums.length + 1];
        for (int key : map.keySet()){
            int freq = map.get(key);
            if (lists[freq] == null){
                lists[freq] = new ArrayList<>();
            }
            lists[freq].add(key);
        }
        for (int i = lists.length - 1, j = k; i >= 0 && j > 0; --i){
            if (lists[i] != null){
                ret.addAll(lists[i]);
                --j;
            }
            //不加判断会输出k个桶的值，加上判断就输出k个值就行
            if (ret.size() == k){
                break;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution347 s = new Solution347();
        //32行加if判断输出-1，3，不加的话输出-1，3，4，5
        int[] arr = {-1, -1, 3, 3, 4, 5};
        List<Integer> res = s.topKFrequent(arr, 1);
        System.out.println(res);
    }
}
