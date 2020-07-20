package huawei.online_test;

import java.util.Scanner;
import java.util.Stack;

/**
 * 华为机试：走迷宫，递归实现
 */
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class MazeTrack {
    private static int rows;
    private static int cols;
    private static Stack<Point> tempPath = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            rows = sc.nextInt();
            cols = sc.nextInt();
            int[][] map = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            mazeTrack(map, 0, 0);
        }
    }

    public static void mazeTrack(int[][] map, int x, int y){
        Point p = new Point(x, y);
        tempPath.push(p);
        map[x][y] = 1;
        if (x == rows - 1 && y == cols - 1) {
            for (Point point : tempPath){
                System.out.println(point.x + "," + point.y);
            }
        }
        if (x + 1 < rows && map[x + 1][y] == 0) { //下
            mazeTrack(map,x + 1, y);
        }
        if (y + 1 < cols && map[x][y + 1] == 0){ //右
            mazeTrack(map, x , y + 1);
        }
        map[x][y] = 0;
        tempPath.pop();
    }
}
