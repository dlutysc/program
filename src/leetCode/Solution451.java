package leetCode;

import java.util.*;

public class Solution451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr){
            int val = map.getOrDefault(c, 0);
            ++val;
            map.put(c, val);
        }
        List<Character>[] buckets = new List[s.length() + 1];
        for (char key : map.keySet()){
            int idx = map.get(key);
            if (buckets[idx] == null) {
                buckets[idx] = new ArrayList<>();
                buckets[idx].add(key);
            }else {
                buckets[idx].add(key);
            }
        }
        StringBuffer res = new StringBuffer();
        for (int freq = buckets.length - 1; freq >= 0; --freq){
            if (buckets[freq] != null){
                Collections.sort(buckets[freq]);
                for (char c : buckets[freq]){
                    for (int i = freq; i > 0; --i){
                        res.append(c);
                    }
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution451 s = new Solution451();
        String str = "tree";
        System.out.println(s.frequencySort(str));
    }
}

