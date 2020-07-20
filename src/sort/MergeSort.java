package sort;

import java.util.Arrays;

/**
 *  @Author chasein
 *  @Date 2020/5/17 16:18
 *  @Description 归并排序
 */
public class MergeSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        mergeSort(sourceArray, 0, sourceArray.length - 1);
        return sourceArray;
    }

    void mergeSort(int[] a, int first, int last){
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(a, first, mid);
            mergeSort(a, mid + 1, last);
            merge(a, first, last);
        }
    }

    void merge(int[] a, int first, int last){
        int mid = (first + last) / 2;
        int i1 = 0;
        int i2 = first;
        int i3 = mid + 1;
        int[] temp = new int[last - first + 1];

        while (i2 <= mid && i3 <= last){
            if (a[i2] < a[i3]){
                temp[i1++] = a[i2++];
            }else {
                temp[i1++] = a[i3++];
            }
        }

        while (i2 <= mid) {
            temp[i1++] = a[i2++];
        }
        while (i3 <= last) {
            temp[i1++] = a[i3++];
        }

        for (int i = first, j = 0; i <= last; i++, j++) {
            a[i] = temp[j];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {3, 5, 1, 2, 4, 6};
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
