package sort;

import java.util.Arrays;

public class BubbleSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return arr;
    }

    void bubbleSort(int[] arr){
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(j, j + 1, arr);
                }
            }
        }
    }

    void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {1, 4, 2, 3};
        bubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
