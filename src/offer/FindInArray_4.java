package offer;

/**
 * 在二维数组中查找某个值
 */
public class FindInArray_4 {
    public static void main(String[] args) {
        int[][] array = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        System.out.println(find(20, array));
        System.out.println(find(9, array));
    }

    public static boolean find(int target, int[][] array){
        if (array == null || array.length == 0) {
            return false;
        }
        int rows = array.length;
        int cols = array[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0){
            if (target < array[row][col]){
                --col;
            }else if (target > array[row][col]){
                ++row;
            }else {
                return true;
            }
        }
        return false;
    }
}
