package offer;
/**
 *  @Author chasein
 *  @Date 2020/9/10 9:29
 *  @Description
 */
public class ReverseSentence_58 {
    public static void main(String[] args) {
        String str = "i am a student.";
        String string = " student. a am I ";
//        String string = "  .tneduts  a ma i  ";
        System.out.println(reverse(string));
//        String res = reverse1(string);
//        System.out.println(res);
//        System.out.println(res.length());

        StringBuilder s = new StringBuilder("  student");
        s.insert(0, "   ");
        System.out.println(s.length());

        StringBuilder space = new StringBuilder();
        if (Character.isSpaceChar(s.charAt(0))){
            for (int i = 0; i < s.length(); i++) {
                if (Character.isLetter(s.charAt(i))){
                    break;
                }
                space.append(" ");
            }
        }

    }
    // 这个方法会把原始字符串两端的空格去掉，字符串中间的超过一个的空格还会保持
    public static String reverse(String str){
        if (str.length() == 0) return str;
        str = str.trim();
        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
//        for (int i = strs.length - 1; i >= 0 ; i--) {
//            for (int j = strs[i].length() - 1; j >= 0 ; j--) {
//                sb.append(strs[i].charAt(j));
//            }
//            sb.append(" ");
//        }
        for(int i = strs.length - 1; i >= 0; --i){
            sb.append(strs[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    // 字符串中间和两端的空格都会保留
    public static String reverse1(String str){
        if (str.length() == 0) return str;
        char[] chars = str.toCharArray();
        // 翻转整个句子
        coreReverse(chars, 0, chars.length - 1);
        // 翻转每个单词
        int blank = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '){
                int nxtBlank = i;
                coreReverse(chars, blank + 1, nxtBlank - 1);
                blank = nxtBlank;
            }
        }
        return new String(chars);
    }

    private static void coreReverse(char[] chars, int low, int high){
        while (low < high){
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }
}
