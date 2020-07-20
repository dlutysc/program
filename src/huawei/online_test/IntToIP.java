package huawei.online_test;

import java.util.Scanner;

public class IntToIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String ip = sc.nextLine();
            String num = sc.nextLine();
            System.out.println(ipToDecimal(ip));
            System.out.println(decimalToIp(num));
        }
    }

    public static String decimalToIp(String str){
        long n = Long.parseLong(str);
        String[] res = new String[4];
        for (int i = 3; i >=0; --i){
            res[i] = (n & 0xff) + ""; //0xff是十六进制的255
            n >>= 8;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4 ; i++) {
            if (i != 3){
                sb.append(res[i] + ".");
            }else {
                sb.append(res[i]);
            }
        }

        return sb.toString();
    }

    public static long ipToDecimal(String ip){
        String[] strArr = ip.split("\\.");
        String[] binArr = new String[4];
        for (int i = 0; i < 4; ++i){
            binArr[i] = Integer.toBinaryString(Integer.parseInt(strArr[i]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; ++i){
            sb.append(format(binArr[i]));
        }
        return Long.parseLong(sb.toString(), 2);
    }

    public static String format(String str){
        StringBuilder sb = new StringBuilder(str);
        for (int j = 0; j < 8 - str.length(); ++j){
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}
