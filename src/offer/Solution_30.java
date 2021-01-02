package offer;

import java.util.Stack;

/**
 *  @Author chasein
 *  @Date 2020/9/24 10:51
 *  @Description 包含min函数的栈
 */
public class Solution_30 {
    Stack<Integer> dataStk = new Stack<>();
    Stack<Integer> minStk = new Stack<>();
    public void push(int node) {
        dataStk.push(node);
        if (minStk.isEmpty()) {
            minStk.push(node);
        }else if (minStk.peek() < node){
            minStk.push(minStk.peek());
        }else {
            minStk.push(node);
        }
    }

    public void pop() {
        if (!dataStk.isEmpty()){
            dataStk.pop();
        }
        if (!minStk.isEmpty()){
            minStk.pop();
        }
    }

    public int top() {
        return dataStk.peek();
    }

    public int min() {
        return minStk.peek();
    }
}
