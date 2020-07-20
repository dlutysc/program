package huawei.online_test;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        List<String> ret = combine(new StringBuilder("abc"), 0, res);
        System.out.println(ret);
    }
    static List<String> combine(StringBuilder str, int begin, List<String> res){
        if (begin == str.length()) {
            res.add(str.toString());
        }
        for(int i = begin; i < str.length(); ++i){
            swap(str, begin, i);
            combine(str, begin + 1, res);
            swap(str, begin, i);
        }
        return res;
    }

    static void swap(StringBuilder str, int begin, int i){
        char temp = str.charAt(begin);
        str.replace(begin, begin + 1, String.valueOf(str.charAt(i)));
        str.replace(i, i + 1, String.valueOf(temp));
    }
}
