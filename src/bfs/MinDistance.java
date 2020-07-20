package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 1091 二进制矩阵中的最短路径
 *
 * 计算在网格中从原点到特定点的最短路径长度
 * 题目描述：1 表示可以经过某个位置，求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。
 */
class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class MinDistance {
    public static void main(String[] args) {
        test();
    }

    static void test(){
        int[][] grids = {
                {1, 1, 0, 1},
                {1, 0, 1, 0},
                {1, 1, 1, 1},
                {1, 0, 1, 1}
        };
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                int minDist = minDistance(grids, i, j);
                System.out.print(minDist + " ");
            }
            System.out.println();
        }


    }

    public static int minDistance(int[][] grids, int tr, int tc){
        Node start = new Node(0, 0);
        Queue<Node> q = new LinkedList<>();
        int rows = grids.length;
        int cols = grids[0].length;
        int dist = 0;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[rows][cols];
        q.add(start);
        visited[0][0] = true;
        int upLevel = 1;
        int downLevel = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.x][node.y] = true;
            if (node.x == tr && node.y == tc) {
                return dist;
            }
            //第一种遍历四个方向的方法，参考别人的代码之后，改为下边的方式，更简洁
//            for (int i = 0; i < 4; i++) {
//                Node nbr = new Node(node.x + dir[i][0], node.y + dir[i][1]);
//                if (nbr.x >= 0 && nbr.x < rows && nbr.y < cols && nbr.y >= 0
//                        && grids[nbr.x][nbr.y] == 1 && visited[nbr.x][nbr.y] == false){
//                    q.add(nbr);
//                    ++downLevel;
//                }
//            }

            for (int[] d : dir) {
                Node nbr = new Node(node.x + d[0], node.y + d[1]);
                if (nbr.x >= 0 && nbr.x < rows && nbr.y < cols && nbr.y >= 0
                        && grids[nbr.x][nbr.y] == 1 && visited[nbr.x][nbr.y] == false){
                    q.add(nbr);
                    ++downLevel;
                }
            }

            --upLevel;
            if (upLevel == 0){
                upLevel = downLevel;
                downLevel = 0;
                ++dist;
            }

        }
        return -1;
    }
}
