package huawei.online_test;

/**
 * 程序员面试金典1.2
 */
public class ReverseString {
    public static void main(String[] agrs){
        String str = "i am a boy";
        System.out.println(reverse(str));
    }

    public static String reverse(String str){
        StringBuffer sb = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; --i){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
