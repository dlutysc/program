package sort;

import java.util.Arrays;

public class QuickSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    void quickSort(int[] a, int low, int high){
        if (low >= high) return; // 1
        int l = low;
        int h = high;
        int key = a[low];
        while (l < h){
            while (l < h && a[h] >= key) {
                --h;
            }
            a[l] = a[h];
            while (l < h && a[l] <= key){
                ++l;
            }
            a[h] = a[l];
        }
        a[l] = key;
        if (low < l - 1) // 把if判断加到此处也可以，这样的话，注释1处的if判断就可以去掉
            quickSort(a, low, l - 1);
        if (l + 1 < high)
            quickSort(a, l + 1, high);
    }

    public static void main(String[] args) {
        IArraySort quickSort = new QuickSort();
        int[] arr = {5, 4, 2, 1, 3};
        int[] res = quickSort.sort(arr);
        System.out.println(Arrays.toString(res));
    }
}
