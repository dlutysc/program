package offer;
/**
 *  @Author chasein
 *  @Date 2021/1/3 15:35
 *  @Description 旋转数组的最小值 二分查找
 */
public class Solution_11 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 1, 2, 3};
        int[] arr1 = new int[]{1, 1, 1, 0, 1, 1};
        System.out.println(findMin(arr));
        System.out.println(findMin(arr1));
    }

    static int findMin(int[] arr){
        int l = 0;
        int r = arr.length - 1;
        while (r - l != 1){
            int mid = (l + r) / 2;
            if (arr[l] == arr[r] && arr[l] == arr[mid]){
                return getMin(arr);
            }
            if (arr[mid] >= arr[l]){
                l = mid;
            }
            if (arr[mid] <= arr[r]){
                r = mid;
            }
            if (r - l == 1){
                return arr[r];
            }
        }
        return -1;
    }

    static int getMin(int[] arr){
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < res) {
                res = arr[i];
            }
        }
        return res;
    }
}
