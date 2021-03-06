package offer;

public class CutRope_14 {
    public static void main(String[] args) {
        CutRope_14 cutRope14 = new CutRope_14();
        System.out.println(cutRope14.maxCut(7));
    }

    public int maxCut(int length){
        if (length < 2){
            return 0;
        }
        if (length == 2){
            return 1;
        }
        if (length == 3){
            return 2;
        }
        int[] memo = new int[length + 1];
        //前四个存储的是绳子的本来长度，不切割（i < 4）
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 3;

        int max;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int temp = memo[j] * memo[i - j]; // memo[i] 表示绳子长度为i(i >= 4)时，剪后的最大值 ,其中i = j + (i - j)
                if (max < temp){
                    max = temp;
                }
                memo[i] = max;
            }
        }
        max = memo[length];
        return max;
    }
}
