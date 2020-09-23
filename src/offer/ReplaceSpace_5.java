package offer;


public class ReplaceSpace_5 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("we are happy");
        System.out.println(replaceSpace(str));
        System.out.println(replaceSpace1(str));
    }

    /**
     * 方法0 str的长度不是目标字符串的长度
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str){
        String s = str.toString();
        char[] arr = s.toCharArray();
        int spaceNum = 0;
        for (char c : arr){
            if (c == ' '){
                ++spaceNum;
            }
        }
        int newArrLen = arr.length + 2 * spaceNum;
        char[] newArr = new char[newArrLen];

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' '){
                newArr[j] = arr[i];
                ++j;
            }else {
                newArr[j] = '%';
                ++j;
                newArr[j] = '2';
                ++j;
                newArr[j] = '0';
                ++j;
            }
        }
        return String.valueOf(newArr);
    }

    /**
     * 方法1
     * @param str
     * @return
     */
    public static String replaceSpace1(StringBuffer str){
        if (str == null){
            return null;
        }
        int srcLen = str.length();
        for (int i = 0; i < srcLen; i++) {
            if (str.charAt(i) == ' '){
                str.append(' ');
                str.append(' ');
            }
        }

        int p1 = srcLen - 1;
        int p2 = str.length() - 1;

        while(p2 > p1){ //不取等号，如果没有空格就不需要进入循环
            if (str.charAt(p1) != ' '){
                str.replace(p2, p2 + 1, String.valueOf(str.charAt(p1)));
                --p1;
                --p2;
            }else {
                str.replace(p2 - 2, p2 + 1, "%20");
                --p1;
                p2 = p2 - 3;
            }
        }

        return str.toString();
    }
}
