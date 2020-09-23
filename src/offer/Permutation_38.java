package offer;

import java.util.Arrays;

public class Permutation_38 {
    private static int num = 0;
    public static void main(String[] args) {
        char[] chars = {'a', 'l', 'i', 'b', 'a', 'b', 'a'};
        char[] chas = {'a', 'b', 'a'};
        permutation(chars, 0);
        System.out.println(num);
    }

    public static void permutation(char[] chars, int begin){
        if (begin == chars.length){
            ++num;
            System.out.println(Arrays.toString(chars));
        }else {
            for (int i = begin; i < chars.length; i++) {
                if (isSwap(chars, begin, i)){
                    swap(chars, begin, i);
                    permutation(chars, begin + 1);
                    swap(chars, begin, i);
                }
            }
        }
    }

    public static void swap(char[] chars, int begin, int i){
        char temp = chars[begin];
        chars[begin] = chars[i];
        chars[i] = temp;
    }

    public static boolean isSwap(char[] chars, int begin, int i){
        boolean flag = true;
        for (int j = begin; j < i; ++j){
            if (chars[j] == chars[i]){
                flag = false;
                return flag;
            }
        }
        return flag;
    }

}
