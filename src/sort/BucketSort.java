package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort implements IArraySort {
    private static final IArraySort insertSort = new InsertSort();
    @Override
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        //bucketSize是桶的大小，即桶中放几个数
        return bucketSort1(arr, 5);
    }

    private int[] bucketSort(int[] arr, int bucketSize){
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }
        //bucketCount是桶的个数，即共有多少个桶
        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index =  (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length > 0) {
                // 对每个桶进行排序，这里使用了插入排序
                bucket = insertSort.sort(bucket);
                for (int value : bucket) {
                    arr[arrIndex++] = value;
                }
            }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    /**
     *
      * @param arr
     * @param bucketSize
     * @return
     */
    public int[] bucketSort1(int[] arr, int bucketSize){
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }
        //bucketCount是桶的个数，即共有多少个桶
        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        List<Integer>[] buckets = new List[bucketCount];
        for (int i = 0; i < arr.length; ++i){
            int idx = (int)Math.floor((arr[i] - minValue) / bucketSize);
            if (buckets[idx] == null){
                buckets[idx] = new ArrayList<>();
                buckets[idx].add(arr[i]);
            }else {
                buckets[idx].add(arr[i]);
            }
        }

        int j = 0;
        for (List<Integer> bucket : buckets){
            //集合的排序必须为非空
            if (bucket != null){
                Collections.sort(bucket);
                for (int val : bucket){
                    arr[j++] = val;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {29, 25, 3, 49, 9, 37, 21, 43, 24, 23, 26, 27};
        IArraySort bucketSort = new BucketSort();
        int[] ret = bucketSort.sort(arr);
        System.out.println(Arrays.toString(ret));
    }
}
