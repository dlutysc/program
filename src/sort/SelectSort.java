package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] a = {3, 2, 5, 4, 1};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void selectSort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]){
                    swap(a, j, i);
                }
            }
        }
    }

    static void swap(int[] a, int j, int i){
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

}
