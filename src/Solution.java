import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private ArrayList<ArrayList<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "catsanddog";
        String[] dicts = new String[]{"cat", "cats", "and", "sand", "dog"};
//        Set<String> dict = new HashSet<String>(){{
//            add("cat");
//            add("cats");
//            add("and");
//            add("sand");
//            add("dog");
//        }};
        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList(dicts));
//        for (String item : dict){
//            System.out.println(item);
//        }
        ArrayList<String> res = solution.wordBreak(s, dict);
        System.out.println(res);
    }

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        String[] dicts = new String[dict.size()];
        dict.toArray(dicts);
        ArrayList<String> list = new ArrayList<>();
        find(s, dicts, list);
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            ArrayList<String> item = res.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < item.size(); j++) {
                if (j != item.size() - 1){
                    sb.append(item.get(j) + " ");
                }else {
                    sb.append(item.get(j));
                }
            }
            ret.add(sb.toString());
        }
        return ret;
    }

    public void find(String str, String[] dicts, ArrayList<String> list){
        if (str.isEmpty()){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < dicts.length; i++) {
            if (str.indexOf(dicts[i]) != 0){
                if (i == dicts.length - 1){
                    list.clear();
                }
            }else {
                list.add(dicts[i]);
                find(str.substring(dicts[i].length()), dicts, list);
            }
        }
    }
}
