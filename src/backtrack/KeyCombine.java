package backtrack;

import java.util.ArrayList;
import java.util.List;

public class KeyCombine {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        KeyCombine keyCombine = new KeyCombine();
        System.out.println(keyCombine.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        doCombination("", combinations, digits);
        return combinations;
    }

    private void doCombination(String prefix, List<String> combinations, final String digits) {
        if (prefix.length() == digits.length()) {
            combinations.add(prefix);
            return;
        }
        int curDigits = digits.charAt(prefix.length()) - '0';
        String letters = KEYS[curDigits];
        for (char c : letters.toCharArray()) {
//            String str = prefix.toString();
//            StringBuilder sb = new StringBuilder(str + c);
            doCombination( prefix + c, combinations, digits);
           // prefix.deleteCharAt(prefix.length() - 1); // 删除
        }
    }
}
