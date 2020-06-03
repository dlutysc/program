import java.util.*;
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] num = {10, 14, 12, 11};
        int[] win = Arrays.copyOf(num, 3);
        System.out.println(Arrays.toString(win));
        System.out.println(solution3.maxInWindows(num, 0));
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num.length < size){
            return null;
        }
        if(size <= 0){
            return new ArrayList<>();
        }
        int[] win = new int[size];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < size; ++i){
            win[i] = num[i];
        }
        int max = win[0];
        for(int i = 1; i < size; ++i){
            if(win[i] > max){
                max = win[i];
            }
        }
        res.add(max);
        for(int i = size; i < num.length; ++i){
            if(num[i] > max){
                max = num[i];
                res.add(max);
            }else if(num[i] < max){
                res.add(getMax(num, i - size + 1, i));
            }else{
                res.add(max);
            }
        }

        return res;
    }

    public int getMax(int[] win, int begin, int end){
        int max = win[begin];
        for(int i = begin + 1; i <= end; ++i){
            if(win[i] > max){
                max = win[i];
            }
        }
        return max;
    }
}
