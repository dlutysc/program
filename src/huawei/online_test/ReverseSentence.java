package huawei.online_test;

import java.util.Scanner;

public class ReverseSentence {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String sentence = in.nextLine();
            char[] cArray = sentence.toCharArray();
            for (int i = 0; i < cArray.length; ++i){
                if (cArray[i] < 'A' || cArray[i] > 'z' || (cArray[i] > 'Z' && cArray[i] < 'a')){
                    cArray[i] = ' ';
                }
            }
            sentence = new String(cArray);
            String[] splitStr = sentence.trim().split("\\s+");
            for (int i = splitStr.length - 1; i >= 1; --i){
                System.out.print(splitStr[i] + " ");
            }
            System.out.print(splitStr[0]);
        }
    }
}
