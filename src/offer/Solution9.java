package offer;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 */
public class Solution9 {
    public static void main(String[] args) {
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
    }

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
