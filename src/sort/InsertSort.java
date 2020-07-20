package sort;

import java.util.Arrays;

public class InsertSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; ++i){
            int k = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > k){
                arr[j] = arr[j - 1];
                --j;
            }
            if (j != i){
                arr[j] = k;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] arr = {1, 3, 5, 0, 2};
        int[] ret = insertSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ret));
    }
}
