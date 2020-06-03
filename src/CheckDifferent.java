/**
 * 程序员面试金典1.1
 */
public class CheckDifferent {
    public static void main(String[] args){
        String str1 = "abcdd";
        System.out.println(isDiff(str1));
        System.out.println(check(str1));
    }

    public static boolean isDiff(String str){
        if (str.length() > 256){
            return false;
        }
        char[] chArr = str.toCharArray();
        int len = chArr.length;
        for (int i = 0; i < len - 1; ++i){
            for (int j = i + 1; j < len; ++j){
                if ((chArr[i] ^ chArr[j]) == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(String str){
        if (str.length() > 256){
            return false;
        }
        boolean[] charSet = new boolean[256];
        for (int i = 0; i < str.length(); ++i){
            int val = str.charAt(i);
            if (charSet[val] == true){
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }
}
