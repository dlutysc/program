package bfs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  @Author chasein
 *  @Date 2020/7/19 15:42
 *  @Description
 */
public class MinDistance1 {
    static int[][] grids = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
    };
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static int rows = grids.length;
    static int cols = grids[1].length;
    static boolean[][] visited = new boolean[rows][cols];

    static void test(){
        // 目标是二维数组的索引
        int minDist = minDistance(rows - 1, cols - 1);
        System.out.println(minDist);
    }

    static int minDistance(int tr, int tc){
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int dist = 0;
        q.add(new Pair<>(0, 0));
        while (!q.isEmpty()){
            int size = q.size();
            ++dist;
            while (size-- > 0){
                Pair<Integer, Integer> cur = q.poll();
                int r = cur.getKey(), c = cur.getValue();
                if (grids[r][c] == 1 || visited[r][c] == true){
                    continue;
                }
                if (r == tr && c == tc) {
                    return dist;
                }
                visited[r][c] = true;
                for (int[] d : dir){
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols){
                        q.add(new Pair<>(nr, nc));
                    }
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        test();
    }
}
