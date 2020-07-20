package huawei.online_test;

import java.util.Scanner;
import java.util.Stack;

/**
 * 华为机试：走迷宫，循环实现
 */
class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Maze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int[][] map = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int[][] dir = {{1, 0}, {0, 1}};
            Stack<Node> stack = new Stack<>();
            int[][] visited = new int[rows][cols];
            Node start = new Node(0, 0);
            Node end = new Node(rows - 1, cols - 1);
            visited[start.x][start.y] = 1;
            stack.push(start);
            while (!stack.empty()) {
                boolean flag = false;
                Node pek = stack.peek();
                if (pek.x == end.x && pek.y == end.y){
                    for (Node node : stack){
                        System.out.println("(" + node.x + "," + node.y + ")");
                    }
                }
                for (int i = 0; i < 2 && !flag; i++) {//循环两个方向
                    Node nbr = new Node(pek.x + dir[i][0], pek.y + dir[i][1]);//找到当前位置的邻居位置坐标并判断是否合法
                    if (nbr.x < rows && nbr.y < cols && map[nbr.x][nbr.y] == 0 && visited[nbr.x][nbr.y] == 0) {//判断邻居节点是否合法
                        stack.push(nbr); //合法将邻居位置加入栈
                        visited[nbr.x][nbr.y] = 1; //并标记该节点已经访问
                        flag = true; //找到了一个方向
                    }
                }
                if (!flag){
                    stack.pop();
                }
            }

        }
    }
}

