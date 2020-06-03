package dfs;

import java.util.Stack;

class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        test();
        test1();
    }

    static void test(){
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxArea(grid));
        System.out.println(maxArea1(grid));
    }

    static void test1(){
        int[][] grid = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        System.out.println(maxArea1(grid));
    }
    /**非递归*/
    static int maxArea(int[][] grid){
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Stack<Node> stack = new Stack<>();
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] mark = new boolean[rows][cols];
        int area = 0;
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    Node start  = new Node(i, j);
                    stack.push(start);
                    mark[start.x][start.y] = true;
                    ++area;
                    while (!stack.isEmpty()){
                        Node cur = stack.pop();
                        for (int[] d : dir){
                            Node nbr = new Node(cur.x + d[0], cur.y + d[1]);
                            if (nbr.x >= 0 && nbr.x < rows && nbr.y >= 0 && nbr.y < cols
                                    && grid[nbr.x][nbr.y] == 1 && mark[nbr.x][nbr.y] == false){
                                stack.push(nbr);
                                mark[nbr.x][nbr.y] = true;
                                ++area;
                            }
                        }
                    }
                    maxArea = area > maxArea ? area : maxArea;
                    area = 0;
                }
            }
        }
        return maxArea;
    }

    /**递归*/
    static int maxArea1(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] mark = new boolean[rows][cols];
        int area = 0;
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && mark[i][j] == false) {
                    ++area;
                    mark[i][j] = true;
                    area += findLand(grid, rows, cols, i, j, mark);
//                    area += findLand1(grid, rows, cols, i + 1, j, mark);
//                    area += findLand1(grid, rows, cols, i - 1, j, mark);
//                    area += findLand1(grid, rows, cols, i, j + 1, mark);
//                    area += findLand1(grid, rows, cols, i, j - 1, mark);
                }
                maxArea = area > maxArea ? area : maxArea;
                area = 0;
            }

        }
        return maxArea;
    }

    static int findLand(int[][] grid, int rows, int cols, int i, int j, boolean[][] mark){
        int area = 0;
        if (i + 1 < rows && mark[i + 1][j] == false && grid[i + 1][j] == 1){
            ++area;
            mark[i + 1][j] = true;
            area += findLand(grid, rows, cols, i + 1, j, mark);
        }
        if (i - 1 >= 0 && mark[i - 1][j] == false && grid[i - 1][j] == 1){
            ++area;
            mark[i - 1][j] = true;
            area += findLand(grid, rows, cols, i - 1, j, mark);
        }
        if (j + 1 < cols && mark[i][j + 1] == false && grid[i][j + 1] == 1){
            ++area;
            mark[i][j + 1] = true;
            area += findLand(grid, rows, cols, i, j + 1, mark);
        }
        if (j - 1 >= 0 && mark[i][j - 1] == false && grid[i][j - 1] == 1){
            ++area;
            mark[i][j - 1] = true;
            area += findLand(grid, rows, cols, i, j - 1, mark);
        }
        return area;
    }

    static int findLand1(int[][] grid, int rows, int cols, int i, int j, boolean[][] mark){
        int area = 0;
        if (i >= 0 && i < rows && j >= 0 && j < cols && mark[i][j] == false && grid[i][j] == 1){
            ++area;
            mark[i][j] = true;
            area += findLand1(grid, rows, cols, i + 1, j, mark);
            area += findLand1(grid, rows, cols, i - 1, j, mark);
            area += findLand1(grid, rows, cols, i, j + 1, mark);
            area += findLand1(grid, rows, cols, i, j - 1, mark);
        }
        return area;
    }
}
