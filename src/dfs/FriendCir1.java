package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chasein
 * @Date 2020/5/15
 * 将测试用例和访问标记数组放到类的属性中
 * 无向图中求连通域的数目
 */
public class FriendCir1 {
    private static int[][] grid = {
            {1, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 1},
            {1, 0, 1, 1}
    };
    private static boolean[] v = new boolean[grid.length];
    private static boolean[] v1 = new boolean[grid.length];

    public static void main(String[] args) {
        System.out.println(cirNum(grid));
        System.out.println(cirNum1(grid));
    }

    /**
     * 图的表示方为邻接矩阵时，dfs的搜索方法
     * @param grid
     * @return
     */
    static int cirNum(int[][] grid){
        int num = 0;
        for (int r = 0; r < grid.length; ++r){
            if (v[r] == false){
                ++num;
                dfs(r);
            }
        }
        return num;
    }

    static void dfs(int r){
        v[r] = true;
        for (int c = 0; c < grid.length; c++) {
            // 将if判断写在递归之前，一般情况是写在刚进入方法时
            if (grid[r][c] == 1 && v[c] == false){
                dfs(c);
            }
        }
    }

    /**
     * 图的表示方为邻接表时，dfs的搜索方法
     * @param grid
     * @return
     */
    static int cirNum1(int[][] grid){
        int num = 0;
        List<Integer>[] graph = buildGraph(grid);
        for (int r = 0; r < graph.length; r++) {
            if (v1[r] == false){
                ++num;
                dfs1(r, graph);
            }
        }
        return num;
    }

    static void dfs1(int r, List<Integer>[] graph){
        v1[r] = true;
        for (int nbr : graph[r]){
            if (!v1[nbr]){
                dfs1(nbr, graph);
            }
        }
    }

    /**
     * 把图的邻接矩阵表示法转换成图的邻接表表示法
     * @param matrix
     * @return
     */
    static List<Integer>[] buildGraph(int[][] matrix){
        List<Integer>[] graph = new List[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            graph[i] = new ArrayList<>();
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1){
                    graph[i].add(j);
                }
            }
        }
        return graph;
    }
}
