package huawei.online_test;

import java.util.Scanner;

public class EncryptString {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String srcStr = in.nextLine();
            System.out.println(encrypt(srcStr));
            String encryptStr = in.nextLine();
            System.out.println(unencrypt(encryptStr));
        }
        in.close();
    }

    public static String encrypt(String srcStr){
        char[] srcChar = srcStr.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < srcChar.length; ++i){
            if (srcChar[i] >= 'a' && srcChar[i] <= 'z'){
                if (srcChar[i] == 'z'){
                    res.append('A');
                }else {
                    res.append((char)(srcChar[i] - 32 + 1));
                }
            }else if (srcChar[i] >= 'A' && srcChar[i] <= 'Z'){
                if (srcChar[i] == 'Z'){
                    res.append('a');
                }else {
                    res.append((char)(srcChar[i] + 32 + 1));
                }
            }else if (srcChar[i] >= '0' && srcChar[i] <= '9'){
                if (srcChar[i] == '9'){
                    res.append('0');
                }else {
                    res.append(srcChar[i] - 48 + 1);
                }
            }else {
                res.append(srcChar[i]);
            }
        }

        return res.toString();
    }

    public static String unencrypt(String encryptStr){
        char[] encryptChar = encryptStr.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < encryptChar.length; ++i){
            if (encryptChar[i] >= 'a' && encryptChar[i] <= 'z'){
                if (encryptChar[i] == 'a'){
                    res.append('Z');
                }else {
                    res.append((char)(encryptChar[i] - 32 - 1));
                }
            }else if (encryptChar[i] >= 'A' && encryptChar[i] <= 'Z'){
                if (encryptChar[i] == 'A'){
                    res.append('z');
                }else {
                    res.append((char)(encryptChar[i] + 32 - 1));
                }
            }else if (encryptChar[i] >= '0' && encryptChar[i] <= '9'){
                if (encryptChar[i] == '0'){
                    res.append('9');
                }else {
                    res.append(encryptChar[i] - 48 - 1);
                }
            }else {
                res.append(encryptChar[i]);
            }
        }

        return res.toString();
    }
}
