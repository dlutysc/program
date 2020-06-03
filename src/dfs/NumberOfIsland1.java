package dfs;

/**
 * @Author chasin
 * @Date 2020/5/15
 * 这个题跟求油田数量是一个类型
 */
public class NumberOfIsland1 {
    private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}
    };
    private static int row = grid.length;
    private static int col = grid[0].length;
    private static boolean[][] v = new boolean[row][col];

    public static void main(String[] args) {
        System.out.println(findIsland(grid));
    }

    static int findIsland(int[][] grid){
        int num = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++){
                if (grid[r][c] == 1 && v[r][c] == false){
                    ++num;
                    dfs(r, c);
                }
            }
        }

        return num;
    }

    static void dfs(int r, int c){
        if (r < 0 || r >= row || c < 0 || c >= col) return;
        if (v[r][c] == true || grid[r][c] != 1) return;
        v[r][c] = true;
        for (int[] d : dir){
            dfs(r + d[0], c + d[1]);
        }
    }
}
