import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        String s = "catsanddog";
        String[] strings = {"cat", "cats", "sand", "and", "dog"};
        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList(strings));
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.wordBreak(s, dict));
    }

    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] arr = new boolean[len + 1];
        arr[0] = true;
        for (int i = 1; i <= len ; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] && dict.contains(s.substring(j, i))){
                    arr[i] = true;
                    break;
                }
            }
        }
        return arr[len];
    }
}
