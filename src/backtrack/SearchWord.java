package backtrack;

public class SearchWord {
    private static int rows;
    private static int cols;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) {
        test();
    }

    static void test(){
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "SEE";
        String word1 = "ABCB";
        String word2 = "ABCCED";
        System.out.println(exist(board, word));
        System.out.println(exist(board, word1));
        System.out.println(exist(board, word2));
    }

    static boolean exist(char[][] board, String word){
        rows = board.length;
        cols = board[0].length;
        boolean[][] mark = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)){
                    if (search(board, i, j, mark, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean search(char[][] board, int i, int j, boolean[][] mark, String word, int k){
        if (k == word.length() - 1){
            return true;
        }
        mark[i][j] = true;
        for (int[] d : dir){
            if (i + d[0] >= 0 && i + d[0] < rows && j + d[1] >= 0 && j + d[1] < cols
                && mark[i + d[0]][j + d[1]] == false
                && board[i + d[0]][j + d[1]] == word.charAt(k + 1)){
                if (search(board, i + d[0], j + d[1], mark, word, k + 1)){
                    return true;
                }
            }
        }
        mark[i][j] = false;
        return false;
    }

}
