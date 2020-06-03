package dfs;

import java.util.*;

/**
 * 图的遍历:bfs
 * 图表示方法：邻接矩阵
 */
public class FriendCir {

    public static int findCircleNum(int[][] M) {
        int num = 0;
        Queue<Integer> que = new LinkedList<>();
        boolean[][] mark = new boolean[M.length][M.length];
        boolean[] flags = new boolean[M.length];
        for (int node = 0; node < M.length; node++) {
            if (flags[node] == false) {
                que.offer(node);
                flags[node] = true;
                while (!que.isEmpty()) {
                    int cur = que.poll();
                    for (int nbr = 0; nbr < M.length; nbr++) {
//                        if (M[cur][nbr] == 1 && cur != nbr && mark[cur][nbr] == false){
//                            que.offer(nbr);
//                            flags[nbr] = true;
//                            mark[cur][nbr] = true;
//                            mark[nbr][cur] = true;
//                        }
                        //mark[cur][nbr] == false 跟 flags[nbr] == false 是等价的
                        if (flags[nbr] == false  && cur != nbr && M[cur][nbr] == 1){
                            que.offer(nbr);
                            flags[nbr] = true;
                            mark[cur][nbr] = true;
                            mark[nbr][cur] = true;
                        }
                    }
                }
                ++num;
            }
        }
        return num;
    }


    public static void main(String[] args) {
       test();
       test1();
    }

    static void test(){
        //本身这个矩阵就是图的邻接矩阵表示法
        int[][] M= {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        System.out.println(findCircleNum(M));
    }

    static void test1(){
        int[][] grid = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1},
        };
        System.out.println(findCircleNum(grid));
    }
}

