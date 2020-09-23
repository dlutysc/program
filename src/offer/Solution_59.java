package offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_59 {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        Solution_59 solution59 = new Solution_59();
        System.out.println(solution59.maxInDequeue(arr, 3));

    }
    public List<Integer> maxInDequeue(int[] array, int size){
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            while (!deque.isEmpty() && array[deque.peekLast()] < array[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        res.add(array[deque.peekFirst()]);

        for (int i = size; i < array.length; i++) {
            if (array[i] < array[deque.peekLast()]){
                deque.addLast(i);
            }else {
                while (!deque.isEmpty() && array[i] >= array[deque.peekLast()]){
                    deque.pollLast();
                }
                deque.addLast(i);
            }
            while (deque.peekLast() - deque.peekFirst() >= size){
                deque.pollFirst();
            }
            res.add(array[deque.peekFirst()]);
        }
        return res;
    }
}
