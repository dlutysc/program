package offer;

public class Solution_15 {
    public static void main(String[] args) {
        System.out.println(numOf1InBinary(9));
        System.out.println(numOf1(9));
        System.out.println(num(9));
    }

    static int numOf1InBinary(int n){
        int count = 0;
        int flag = 1;
        // 循环32次
        while (flag != 0){
            if ((n & flag) != 0){
                ++count;
            }
            flag = flag << 1;
        }
        return count;
    }

    static int numOf1(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = (n & n - 1);
        }
        return count;
    }

    static int num(int n){
        return Integer.bitCount(n);
    }
}
