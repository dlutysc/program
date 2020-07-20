package huawei.online_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int check(String key, char[] keyChar, String dicStr){
        if (key.equals(dicStr) || key.length() != dicStr.length())
            return 0;
        char[] dicChar = dicStr.toCharArray();
        Arrays.sort(dicChar);
        return Arrays.equals(keyChar, dicChar)? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int dicSize = in.nextInt();
            String[] strDic = new String[dicSize];
            for (int i = 0; i < dicSize; ++i){
                strDic[i] = in.next();
            }
            String key = in.next();  //key为要查找的单词
            char[] keyChar = key.toCharArray();
            Arrays.sort(keyChar);
            int num = in.nextInt();  //num为输出第几个
            ArrayList<String> sList = new ArrayList<String>();
            int count = 0;
            for (int i = 0; i < dicSize; ++i){
                int c = check(key, keyChar, strDic[i]);
                count += c;
                if (c == 1){
                    sList.add(strDic[i]);
                }
            }
            Collections.sort(sList);
            System.out.print(count);
            if (count >= num){
                System.out.println(sList.get(num - 1));
            }
        }
    }
}
