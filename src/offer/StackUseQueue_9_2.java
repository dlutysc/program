package offer;

import java.util.LinkedList;
import java.util.Queue;
/**
 *  @Author chasein
 *  @Date 2021/1/2 11:01
 *  @Description 用两个对列实现栈
 */
public class StackUseQueue_9_2 {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    public void push(int val){
        if (!queue1.isEmpty()){
            queue1.add(val);
        }else {
            queue2.add(val);
        }
    }

    public int pop(){
        if (!queue1.isEmpty()){
            if (queue1.size() == 1){
                return queue1.remove();
            }else {
                while (queue1.size() != 1){
                    queue2.add(queue1.remove());
                }
                return queue1.remove();
            }
        }else {
            if (queue2.size() == 1){
                return queue2.remove();
            }else {
                while (queue2.size() != 1){
                    queue1.add(queue2.remove());
                }
                return queue2.remove();
            }
        }
    }

    public static void main(String[] args) {
        StackUseQueue_9_2 stack = new StackUseQueue_9_2();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
    }
}
