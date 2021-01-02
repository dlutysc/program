package offer;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 */
public class Solution_9 {
    public static void main(String[] args) throws Exception{
        MyQueue q = new MyQueue();
        q.enqueue(1);
        q.enqueue(3);
        System.out.println(q.dequeue());
        q.enqueue(2);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(4);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        MyStack stack = new MyStack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            stack.pop();
        }
        for (int i = 0; i < 1; i++) {
            System.out.println(stack.pop());
        }
    }
//
//    static class MyQueue{
//        private Stack<Integer> data = new Stack<>();
//        private Stack<Integer> helper = new Stack<>();
//
//        public void enqueue(int x){
//            data.push(x);
//        }
//
//        public Integer dequeue() {
//            if (helper.isEmpty()){
//                while (!data.isEmpty()){
//                    helper.push(data.pop());
//                }
//            }
//            if (!helper.isEmpty()){
//                return helper.pop();
//            }else {
//                System.out.print("队列为空");
//                return null;
//            }
//        }
//    }

}

class MyQueue{
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> helper = new Stack<>();

    public void enqueue(int x){
        data.push(x);
    }

    public Integer dequeue() {
        if (helper.isEmpty()){
            while (!data.isEmpty()){
                helper.push(data.pop());
            }
        }
        if (!helper.isEmpty()){
            return helper.pop();
        }else {
            System.out.print("队列为空");
            return null;
        }
    }
}

/**
 *  @Author chasein
 *  @Date 2021/1/1 14:09
 *  @Description 用数组实现一个栈
 */
class MyStack{
    private static final int ARRAY_LEN = 5;
    private int[] arr = new int[ARRAY_LEN];
    private int idx = -1;
    public void push(int val) throws Exception{
        if (idx + 1 == arr.length){
            System.out.println("满");
            throw new Exception();
        }
        arr[idx + 1] = val;
        ++idx;
    }
    public int pop() throws Exception{
        if (idx == -1){
            System.out.println("空");
            throw new Exception();
        }
        int val = arr[idx];
        --idx;
        return val;
    }
}


