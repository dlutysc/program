package dfs.algorithm_competition;

/**
 * 将测试用例和方位标记数组放到类的属性里
 */
public class OilDeposit1 {
    private static char[][] grid = {
            {'*','*','*','*','@'},
            {'*','@','@','*','@'},
            {'*','@','*','*','@'},
            {'@','*','@','*','*'},
            {'@','@','*','*','@'}
    };
    private static boolean[][] v = new boolean[grid.length][grid.length];
    private static int cnt = 0;
    // 八个方向
    private static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    
    public static void main(String[] args) {
        for (int r = 0; r < grid.length; ++r){
            for (int c = 0; c < grid.length; ++c){
                if (v[r][c] == false && grid[r][c] == '@'){
                    ++cnt;
                    findOil(r, c);
                }
            }
        }
        System.out.println(cnt);
    }
    
    static void findOil(int r, int c){
        if (r < 0 || r >= grid.length || c < 0 || c >= grid.length) return;
        if (v[r][c] == true || grid[r][c] != '@') return;
        v[r][c] = true;
        // 两种方式遍历
//        for (int dr = -1; dr <= 1; dr++) {
//            for (int dc = -1; dc <= 1 ; dc++) {
//                if (dr != 0 || dc != 0){
//                    findOil(r + dr, c + dc);
//                }
//            }
//        }

        for (int[] d : dir){
            findOil(r + d[0], c + d[1]);
        }
    }
}
