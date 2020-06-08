# 深度优先搜索

## 1  求油田的个数

### 题目描述

算法竞赛书上例题 6-12

‘@’的上下左右或对角线是‘@’，就是属于同一个油田，求油田个数

### 解题方法

```java
/**
 * @Date 2020/5/13
 * @Author chasein
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
```

***

```java
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
```

## 2  朋友圈个数

### 题目描述

leetcode 547

```java
本身这个矩阵就是图的邻接矩阵表示法
一个朋友圈
1-4-2-3
  1  2  3  4
1{1, 0, 0, 1}
2{0, 1, 1, 0}
3{0, 1, 1, 1}
4{1, 0, 1, 1}

两个朋友圈
1-2
3
  1  2  3
1{1, 1, 0}
2{1, 1, 0}
3{0, 0, 1}
```

### 解题方法

```java
/**
 * @Author chasein
 * @Date 2020/5/15
 * 将测试用例和访问标记数组放到类的属性中
 * 无向图中求连通域的数目
 */
public class FriendCir1 {
    private static int[][] grid = {
            {1, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 1},
            {1, 0, 1, 1}
    };
    private static boolean[] v = new boolean[grid.length];
    private static boolean[] v1 = new boolean[grid.length];

    public static void main(String[] args) {
        System.out.println(cirNum(grid));
        System.out.println(cirNum1(grid));
    }

    /**
     * 图的表示方法为邻接矩阵时，dfs的搜索方法
     * @param grid
     * @return
     */
    static int cirNum(int[][] grid){
        int num = 0;
        for (int r = 0; r < grid.length; ++r){
            if (v[r] == false){
                ++num;
                dfs(r);
            }
        }
        return num;
    }

    static void dfs(int r){
        v[r] = true;
        for (int c = 0; c < grid.length; c++) {
            // 将if判断写在递归之前，一般情况是写在刚进入方法时
            if (grid[r][c] == 1 && v[c] == false){
                dfs(c);
            }
        }
    }

    /**
     * 图的表示方为邻接表时，dfs的搜索方法
     * @param grid
     * @return
     */
    static int cirNum1(int[][] grid){
        int num = 0;
        List<Integer>[] graph = buildGraph(grid);
        for (int r = 0; r < graph.length; r++) {
            if (v1[r] == false){
                ++num;
                dfs1(r, graph);
            }
        }
        return num;
    }

    static void dfs1(int r, List<Integer>[] graph){
        v1[r] = true;
        for (int nbr : graph[r]){
            if (!v1[nbr]){
                dfs1(nbr, graph);
            }
        }
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
}
```

## 3  求最大岛屿

### 题目描述

leetcode 695 岛屿的最大面积

1代表是陆地，1的上下左右是1就代表是同一块岛屿

### 解题方法

```java
/**
 *  @Author chasein
 *  @Date 2020/5/15 17:11
 *  @Description
 */
public class MaxIsland {
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
    int row = grid.length;
    int col = grid[0].length;
    boolean[][] v = new boolean[row][col];
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        MaxIsland maxIsland = new MaxIsland();
        int max = maxIsland.maxArea(maxIsland.grid);
        System.out.println(max);
    }

    int maxArea(int[][] grid){
        int area = 0;
        int maxArea = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1 && v[r][c] == false){
                    area = dfs(r, c);
                }
                maxArea = area > maxArea ? area : maxArea;
            }
        }
        return maxArea;
    }

    int dfs(int r, int c){
        if (r < 0 || r >= row || c < 0 || c >= col) return 0;
        if (grid[r][c] == 0 || v[r][c] == true) return 0;
        v[r][c] = true;
        int area = 1;
        for (int[] d : dir) {
            area += dfs(r + d[0], c + d[1]);
        }

        return area;
    }
}
```

## 4  求岛屿的个数

### 题目描述

此题跟第1个，求油田的个数类型一样，只不过这个遍历的方向是4个

### 解题方法

```java
/**
 * @Author chasin
 * @Date 2020/5/15
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
```

## 5 太平洋大西洋水流问题

### 题目描述

leetcode 417

```java
Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:
[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
```

左边和上边是太平洋，右边和下边是大西洋，内部的数字代表海拔，海拔高的地方的水能够流到低的地方，求解水能够流到太平洋和大西洋的所有位置。

### 解题方法

```java
/**
 *  @Author chasein
 *  @Date 2020/5/16 11:52
 *  @Description
 *  leetcode 417 太平洋大西洋水流问题
 */
public class PacificAtlantic1 {
    static int[][] board = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
    };
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int rows = board.length;
    int cols = board[0].length;
    boolean[][] p = new boolean[rows][cols];
    boolean[][] a = new boolean[rows][cols];

    public static void main(String[] args) {
        PacificAtlantic1 pa = new PacificAtlantic1();
        System.out.println(pa.pacificAtlantic());
    }

    List<List<Integer>> pacificAtlantic(){
        for (int r = 0; r < rows; r++) {
            if (p[r][0] == false) dfs(r, 0, p);
            if (a[r][cols - 1] == false) dfs(r, cols - 1, a);
        }
        for (int c = 0; c < cols; c++) {
            if (p[0][c] == false) dfs(0, c, p);
            if (a[rows - 1][c] == false) dfs(rows - 1, c, a);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (p[i][j] == true && a[i][j] == true){
                    List<Integer> item = new ArrayList<>(Arrays.asList(i, j));
                    res.add(item);
                }
            }

        }

        return res;
    }

    void dfs(int r, int c, boolean[][] v){
        // 注释掉的原因是因为跟下面的判断重复了
//        if (r < 0 || r >= rows || c < 0 || c >= cols) return;
        if (v[r][c] == true) return;
        v[r][c] = true;
        for (int[] d : dir){
            // 将if判断写在递归之前，一般情况是写在刚进入方法时，像上面注释掉的那个位置。
            if(r + d[0] < rows && r + d[0] >= 0 && c + d[1] < cols && c + d[1] >= 0 && board[r + d[0]][c + d[1]] >= board[r][c]){
                dfs(r + d[0], c + d[1], v);
            }
        }
    }
}

```

