package huawei.online_test;

import java.util.Scanner;

/**
 * 华为机试：按字节截取字符串
 */
public class CutString {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String[] strs = new String[str.length()];
            for (int i = 0; i < strs.length; i++) {
                strs[i] = String.valueOf(str.charAt(i));
            }
            int byteNum = sc.nextInt();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < strs.length; i++) {
                int chLen = strs[i].getBytes("GBK").length;
                if (byteNum >= chLen){
                    byteNum -= chLen;
                    res.append(strs[i]);
                }else {
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
