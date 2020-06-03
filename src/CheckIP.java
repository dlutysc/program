import java.util.Arrays;
import java.util.Scanner;

/**
 * 华为机试：判断两个IP是否属于同一个子网
 */
public class CheckIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String mask = sc.next();
            String ip1 = sc.next();
            String ip2 = sc.next();
            System.out.println(isMaskLegal(mask));
            if (isMaskLegal(mask) && isIpLegal(ip1) && isIpLegal(ip2)){
                if (checkNet(mask, ip1, ip2)){
                    System.out.println(0);
                }else {
                    System.out.println(2);
                }
            }else {
                System.out.println(1);
            }

        }

    }

    public static boolean isMaskLegal(String mask){
        String[] strArr = mask.split("\\.+");
        if (strArr.length > 4 || strArr.length < 1){
            return false;
        }
        String[] binArr = new String[strArr.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; ++i){
            binArr[i] = Integer.toBinaryString(Integer.parseInt(strArr[i]));
            sb.append(binArr[i]);
        }
        if (sb.toString().contains("01")){
            return false;
        }
        return true;
    }

    public static boolean isIpLegal(String str){
        //检查点数量
        int dotCount = 0;
        for(int i = 0; i < str.length(); ++i){
            if (str.charAt(i) == '.'){
                dotCount++;
            }
        }
        if (dotCount != 3){
            return false;
        }
        //检查是否是四个值
        String[] strArr = str.split("\\.+");
        if (strArr.length != 4){
            return false;
        }
        //检查每个值是否在0-255之间
        for (int i = 0; i < strArr.length; i++) {
            int num = Integer.parseInt(strArr[i]);
            if (num > 255 || num < 0){
                return false;
            }
        }
        return true;
    }

    public static boolean checkNet(String mask, String ip1, String ip2){
        String[] masks = mask.split("\\.");
        String[] ip1s = ip1.split("\\.");
        String[] ip2s = ip2.split("\\.");
        int maskLen = masks.length;
        int[] res1 = new int[maskLen];
        int[] res2 = new int[maskLen];
        for (int i = 0; i < maskLen; ++i){
            res1[i] = Integer.parseInt(ip1s[i]) & Integer.parseInt(masks[i]);
            res2[i] = Integer.parseInt(ip2s[i]) & Integer.parseInt(masks[i]);
        }

        return Arrays.equals(res1, res2);
    }
}
