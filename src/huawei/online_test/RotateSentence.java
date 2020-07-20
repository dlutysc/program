package huawei.online_test;

public class RotateSentence {
    public static void main(String[] args){
        String srcStr = "  i am    a student!   ";
        char[] chas = srcStr.toCharArray();
        rotateSentence(chas);
        String res = new String(chas);
        System.out.println(res);
        System.out.println(srcStr.length());
        System.out.println(res.length());
    }

    public static void rotateSentence(char[] charArr){
        if (charArr == null || charArr.length == 0){
            return;
        }
        int len = charArr.length;
        reverse(charArr, 0, len - 1);
        int left = -1;
        int right = -1;
        for (int i = 0; i < len; ++i){
            if (i == 0){
                left = i;
            }else if (i >= 1 && charArr[i - 1] == ' ' && charArr[i] != ' '){
                left = i;
            }else if (i <= len - 2 && charArr[i] != ' ' && charArr[i + 1] == ' '){
                right = i;
            }else if (i == len - 1){
                right = i;
            }

            if (left != -1 && right != -1){
                reverse(charArr, left, right);
                left = -1;
                right = -1;
            }
        }
    }

    public static void reverse(char[] chas, int start, int end){
        if (chas == null || chas.length == 0){
            return;
        }
        while (start < end){
            char temp = chas[start];
            chas[start] = chas[end];
            chas[end] = temp;
            ++start;
            --end;
        }
    }
}
