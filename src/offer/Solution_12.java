package offer;


/**
 *  @Author chasein
 *  @Date 2021/1/3 16:59
 *  @Description 待进行oj验证
 */
public class Solution_12 {
    static char[][] matrix = {
            {'a', 'b', 't', 'g'},
            {'c', 'f', 'c', 's'},
            {'j', 'd', 'e', 'h'}};
    static int rows = matrix.length;
    static int cols = matrix[0].length;
    static int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static boolean[][] v = new boolean[rows][cols];
    public static void main(String[] args) {
        String word = "bfcee";
        System.out.println(exist(word));
    }

    static boolean exist(String word){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // if 判断中不用加v[i][j] == false，因为如果是第二次(或者是第n次)进入if，就说明上次的查询失败，没有找到该单词，已经
                // 回溯，已标为false
                if (matrix[i][j] == word.charAt(0)){
                    if (find(i, j, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean search(int i, int j, String word, int k){
        if (k == word.length() - 1){
            return true;
        }
        v[i][j] = true;
        for (int[] dir : dirs){
            if (i + dir[0] < rows && i + dir[0] >= 0 && j + dir[1] >= 0 && j + dir[1] < cols
                && v[i + dir[0]][j + dir[1]] == false && matrix[i + dir[0]][j + dir[1]] == word.charAt(k + 1)){
                if (search(i + dir[0], j + dir[1], word, k + 1)){
                    return true;
                }
            }
        }
        v[i][j] = false;
        return false;
    }

    static boolean find(int i, int j, String word, int k){
        // 注意与search方法的不同
        if (k == word.length()){
            return true;
        }
        if (i  >= rows || i < 0 || j < 0 || j >= cols){
            return false;
        }
        if (v[i][j] == true || matrix[i][j] != word.charAt(k)){
            return false;
        }
        v[i][j] = true;
        for (int[] dir : dirs){
            if (find(i + dir[0], j + dir[1], word, k + 1)){
                return true;
            }
        }
        v[i][j] = false;
        return false;
    }
}
