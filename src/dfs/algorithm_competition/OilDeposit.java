package dfs.algorithm_competition;

/**
 * @Date 2020/5/13
 * @Author chasein
 * 算法竞赛书上例题 6-12
 * ‘@’的上下左右或对角线是‘@’，就是属于同一个油田，求油田个数
 *
 *
 * 解题方法注释：将测试用例和访问标记的数组放到main方法里
 * 递归调用时，需要多传两个参数，测试用例和访问标记数组
 *
 * 这种矩阵不能转换成图，只是一个矩阵而已
 * 朋友圈的那个矩阵能转换成图
 * 所以搜索方法稍有不同
 */
public class OilDeposit {
    public static void main(String[] args) {

        char[][] grid = {
                {'*','*','*','*','@'},
                {'*','@','@','*','@'},
                {'*','@','*','*','@'},
                {'@','*','@','*','*'},
                {'@','@','*','*','*'}
        };
        boolean[][] v = new boolean[grid.length][grid.length];
        System.out.println(findOil(grid, v));
    }

    static int findOil(char[][] grid, boolean[][] v){
        int num = 0;
        for (int r = 0; r < grid.length; ++r){
            for (int c = 0; c < grid.length; ++c){
                if (v[r][c] == false && grid[r][c] == '@'){
                    ++num;
                    dfs(grid, v, r, c);
                }
            }
        }

        return num;
    }

    static void dfs(char[][] grid, boolean[][] v, int r, int c){
        // 先判断是否出界，再判断是否已经访问过、是否是‘@’
        if (r < 0 || c < 0 || r >= grid.length || c >= grid.length) return; // 出界
        if (v[r][c] == true || grid[r][c] != '@') return; // 已经访问过或者不是‘@’
        v[r][c] = true;
        for (int dr = -1; dr <= 1; ++dr){
            for (int dc = -1; dc <= 1 ; dc++) {
                if (dr != 0 || dc != 0){
                    dfs(grid, v, r + dr, c + dc);
                }
            }
        }
    }
}
