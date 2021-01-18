package offer;

import java.util.ArrayList;
import java.util.List;
/**
 *  @Author chasein
 *  @Date 2021/1/18 20:29
 *  @Description 机器人的运动范围 （好像也不用回溯）
 */
public class Solution_13 {
    static int rows = 4;
    static int cols = 4;
    static int threshold = 3;
    static boolean[][] v = new boolean[rows][cols];
    static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (count(i, j) <= threshold){
                    cnt += search(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    static int search(int i, int j){
        if (i < 0 || i >= rows || j < 0 || j >= cols) return 0;
        if (v[i][j] == true || count(i, j) > threshold) return 0;
        v[i][j] = true;
        int cnt = 0;
        ++cnt;
        for (int[] dir : dirs){
            cnt += search(i + dir[0], j + dir[1]);
        }
        return cnt;
    }

    static int count(int i, int j){
        return getSum(i) + getSum(j);
    }

    static int getSum(int n){
        List<Integer> list = new ArrayList<>();
        while (n != 0){
            int i = n % 10;
            n = n / 10;
            list.add(i);
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
