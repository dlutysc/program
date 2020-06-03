package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 图的遍历：dfs和bfs
 * leetcode 547 朋友圈
 *
 */
public class FriendCircle {
    public static void main(String[] args) {
        test();
        test1();
    }

    static void test(){
        /**
         * 本身这个矩阵就是图的邻接矩阵表示法
         * 一个朋友圈
         * 1-4-2-3
         */
        int[][] grid = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        System.out.println(circleNum(grid));
        System.out.println(friendCircle(grid));
        System.out.println(cirNum(grid));
    }

    static void test1(){
        /**
         * 两个朋友圈
         * 1-2
         * 3
         */
        int[][] grid = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1},
        };
        System.out.println(circleNum(grid));
        System.out.println(friendCircle(grid));
        System.out.println(cirNum(grid));
    }


    /**
     * dfs:图的表示方法为邻接表
     * 递归
     */
    static int circleNum(int[][] matrix){
        List<Integer>[] graph = buildGraph(matrix);
        boolean[] mark = new boolean[graph.length];
        int num = 0;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == false){
                ++num;
//                mark[i] = true;
                dfs(graph, i, mark);
            }
        }
        return num;
    }

    static void dfs(List<Integer>[] graph, int i, boolean[] v) {
        v[i] = true;
        for (int nbr : graph[i]){
            if (!v[nbr]){
                dfs(graph, nbr, v);
            }

        }
    }

    /**bfs，图的表示方法为邻接表*/
    static int friendCircle(int[][] matrix){
        List<Integer>[] graph = buildGraph(matrix);
        Queue<Integer> q = new LinkedList<>();
        boolean[] mark = new boolean[graph.length];
        int num = 0;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == false){
                ++num;
                q.offer(i);
                mark[i] = true;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for(int nbr : graph[cur]){
                        if (mark[nbr] == false) {
                            q.offer(nbr);
                            mark[nbr] = true;
                        }
                    }
                }
            }
        }
        return num;
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

    /**dfs:图的表示方法为邻接矩阵,递归*/
    static int cirNum(int[][] grid){
        boolean[] visited = new boolean[grid.length];
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            if (visited[i] == false){
                ++num;
                findFriend(grid, i, visited);
            }
        }
        return num;
    }

    static void findFriend(int[][] grid, int i, boolean[] visited){
        visited[i] = true;
        for (int j = 0; j < grid.length; j++) {
            if (grid[i][j] == 1 && visited[j] == false) {
                findFriend(grid, j, visited);
            }
        }
    }


}
