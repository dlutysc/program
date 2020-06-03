package dfs;

import java.util.Stack;

public class NumberOfIsland {
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) {
        test();
    }

    static void test(){
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println(islandNum(grid));
        System.out.println(islandNum1(grid));
    }
    //非递归
    static int islandNum(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] mark = new boolean[rows][cols];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Stack<Node> stk = new Stack<>();
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && mark[i][j] == false){
                    Node start = new Node(i, j);
                    stk.push(start);
                    mark[start.x][start.y] = true;
                    while (!stk.isEmpty()) {
                        Node cur = stk.pop();
                        for (int[] d : dir){
                            Node nbr = new Node(cur.x + d[0], cur.y + d[1]);
                            if (nbr.x >= 0 && nbr.x < rows && nbr.y >= 0 && nbr.y < cols
                                    && grid[nbr.x][nbr.y] == 1 && mark[nbr.x][nbr.y] == false){
                                stk.push(nbr);
                                mark[nbr.x][nbr.y] = true;
                            }
                        }
                    }
                    ++num;
                }
            }
        }
        return num;
    }

    //递归
    static int islandNum1(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] mark = new boolean[rows][cols];
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && mark[i][j] == false) {
//                    mark[i][j] = true; //方法1
//                    findLand(grid, rows, cols, i, j, mark); // 方法1
                    findLand1(grid, rows, cols, i, j, mark); //方法2
                    ++num;
                }

            }
        }
        return num;
    }

    //递归方法1
    static void findLand(int[][] grid, int rows, int cols, int i, int j, boolean[][] mark){
        if (i + 1 < rows && grid[i + 1][j] == 1 && mark[i + 1][j] == false) {
            mark[i + 1][j] = true;
            findLand(grid, rows, cols, i + 1, j, mark);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == 1 && mark[i - 1][j] == false) {
            mark[i - 1][j] = true;
            findLand(grid, rows, cols, i - 1, j, mark);
        }
        if (j + 1 < cols && grid[i][j + 1] == 1 && mark[i][j + 1] == false) {
            mark[i][j + 1] = true;
            findLand(grid, rows, cols, i, j + 1, mark);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1 && mark[i][j - 1] == false) {
            mark[i][j - 1] = true;
            findLand(grid, rows, cols, i, j - 1, mark);
        }
        return;
    }

    //递归方法2
    static void findLand1(int[][] grid, int rows, int cols, int i, int j, boolean[][] mark){
        if (i < 0 || i >= rows || j < 0 || j >= cols || mark[i][j] == true || grid[i][j] == 0){
            return;
        }
        mark[i][j] = true;
        for (int[] d : dir){
            findLand1(grid, rows, cols, i + d[0], j + d[1], mark);
        }
    }
}
