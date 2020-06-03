package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode
 * 279. Perfect Squares (Medium)
 * 可以将每个整数看成图中的一个节点，如果两个整数之差为一个平方数，那么这两个整数所在的节点就有一条边。
 *
 * 要求解最小的平方数数量，就是求解从节点 n 到节点 0 的最短路径。
 *
 * 本题也可以用动态规划求解，在之后动态规划部分中会再次出现。
 * bfs得方法在leetCode上运行超时
 */
public class PerfectSquares {
    public static void main(String[] args) {
        test();
    }
    static void test(){
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
        System.out.println(numSquares(16));
        System.out.println(numSquares(11));
        System.out.println(numSquares(7168)); //有明显得卡顿
    }
    static int numSquares(int n){
        Queue<Integer> q = new LinkedList<>();
        List<Integer> squares = getSquares(n);
        boolean[] mark = new boolean[n + 1];
        q.offer(n);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0){
                int cur = q.poll();
                mark[cur] = true;
                if (cur == 0){
                    return res;
                }
                for (int square : squares){
                    int next = cur - square;
                    if (next >= 0 && mark[next] == false){
                        q.offer(next);
                    }
                    if (next < 0){
                        break;
                    }
                }
            }
            res++;
        }
        return 0;
    }

    static List<Integer> getSquares(int n){
        List<Integer> squares = new ArrayList<>();
        int temp = 1;
        for (int i = 2; temp <= n; i++) {
            squares.add(temp);
            temp = i * i;
        }
        return squares;
    }
}
