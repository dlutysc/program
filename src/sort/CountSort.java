package sort;

import java.util.Arrays;

public class CountSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxVal = getMax(sourceArray);
        countSort(arr, maxVal);
        return arr;
    }

    public int[] countSort(int[] arr, int maxVal){
        int[] bucket = new int[maxVal + 1];
        for (int val : arr){
            bucket[val]++;
        }
        int sortedIdx = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] != 0){
                arr[sortedIdx++] = i;
                bucket[i]--;
            }
        }
        return arr;
    }

    private int getMax(int[] a){
        int max = a[0];
        for (int v : a){
            if (v > max){
                max = v;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        IArraySort countSort = new CountSort();
        int[] arr = {1, 3, 5, 0, 2};
        int[] ret = countSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ret));
    }
}
