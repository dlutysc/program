package offer;
/**
 *  @Author chasein
 *  @Date 2021/1/2 11:46
 *  @Description 斐波那契 青蛙跳台阶
 */
public class Solution_10 {
    public static void main(String[] args) {
        System.out.println(fib(25));
    }
    // 非递归
    static long fib(long n){
        if (n == 0 || n == 1){
            return n;
        }
        long pre = 0;
        long cur = 1;
        long res = 0;
        for (long i = 2; i <= n; i++) {
            res = pre + cur;
            pre = cur;
            cur = res;
        }
        return res;
    }
}
