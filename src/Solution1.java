import java.util.*;

class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String s = "catsandog";
        String[] dicts = new String[]{"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = new ArrayList<>();
        wordDict.addAll(Arrays.asList(dicts));
        System.out.println(solution1.wordBreak(s, wordDict));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> memo = new HashMap<>();
        Set<String> dict = new HashSet<>();
        for (String w : wordDict) {
            dict.add(w);
        }
        return wordBreakHelper(s, dict, memo);
    }

    private List<String> wordBreakHelper(String s, Set<String> dict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> res = new ArrayList<>();
        if (dict.contains(s)) {
            res.add(s);
        }
        for (int i = 1; i < s.length(); ++i) {
            String pre = s.substring(0, i);
            if (!dict.contains(pre)) {
                continue;
            }
            List<String> list = wordBreakHelper(s.substring(i), dict, memo);
            for (String next : list) {
                res.add(pre + " " + next);
            }
        }
        memo.put(s, res);
        return res;
    }
}

