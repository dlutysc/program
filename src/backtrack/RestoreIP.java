package backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
    public static void main(String[] args) {
        test();
    }

    static void test(){
        String str = "25525511135";
        List<String> res = new ArrayList<>();
        restore(str, new StringBuilder(), res, 0);
        System.out.println(res);
    }

    static void restore(String str, StringBuilder tempIP, List<String> res, int k){
        if (k ==4 || str.length() == 0){
            if (k == 4 && str.length() == 0){
                res.add(tempIP.toString());
            }
            return;
        }


        for (int i = 0; i < 3 && i < str.length(); i++) {
            String part = str.substring(0, i + 1);
            if (isValid(part)){
                if (tempIP.length() != 0){
                    part = "." + part;
                }
                tempIP.append(part);
                restore(str.substring(i + 1), tempIP, res, k + 1);
                tempIP.delete(tempIP.length() - part.length(), tempIP.length());
            }

        }

    }

    static boolean isValid(String part){
        if (part == null || part.length() == 0 || (part.charAt(0) == '0' && part.length() > 1)
                || Integer.parseInt(part) > 255){
            return false;
        }
        return true;
    }
}
