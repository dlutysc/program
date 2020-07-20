package sort;

import java.util.Arrays;

public class Part {
    public static int partition(int[] arr, int l, int h){
        int i = l, j = h;
        while (true){
            while (i <= h && arr[i] <= arr[l]){
                ++i;
            }
            while (j >= l && arr[j] >= arr[l]){
                --j;
            }
            if (i >= j){
                break;
            }
            if (i <= h && j >= 0){
                swap(arr, i, j);
            }

        }
        if (j == -1){
            j = 0;
        }
        swap(arr, l, j);
        return j;
    }
    /**
     *  @Author chasein
     *  @Date 2020/5/17 14:43
     *  @Description 一趟快速排序，快速排序就是在此方法基础上加两个递归调用，见快速排序代码
     */
    public static int partition1(int[] a, int low, int high){
        int l = low;
        int h = high;
        int key = a[low];
        while (l < h){
            while (l < h && a[h] >= key) --h;
            a[l] = a[h];
            while (l < h && a[l] <= key) ++l;
            a[h] = a[l];
        }
        a[l] = key;
        return l;
    }

    private static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 2, 4, 6};
        int[] arr1 = {3, 2, 1};
        int[] arr2 = {1, 2, 3};
//        partition(arr, 0, arr.length - 1);
//        partition(arr1, 0, arr1.length - 1);
//        partition(arr2, 0, arr2.length - 1);

        partition1(arr, 0, arr.length - 1);
        partition1(arr1, 0, arr1.length - 1);
        partition1(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
