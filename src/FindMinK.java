/**
 * 猿辅导2017面试题
 */
public class FindMinK {
    public static void main(String[] args) {
        find(new int[]{1}, 2);//-1
         find(new int[]{2,3}, 2);//1
         find(new int[]{1,2}, 2);//2
         find(new int[]{1,3,4}, 3); //2
         find(new int[]{1,2,2,2,2}, 2);//2
        find(new int[]{2,2,2,2,2}, 2);//1
        find(new int[]{1,1,3,3,4,5}, 2);//-1

        System.out.println(check(1119));
        System.out.println(check(101110));

//        find1(2);
//        find1(3);
//        find1(18);

        System.out.println(isExist(new int[][]{{1, 2, 3}, {3, 5, 6}, {4, 8, 9}}, 7));

    }

    static void find(int[] arr, int m){
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] == m){
                System.out.println(i + 1);
                return;
            }
        }
        if (i == arr.length){
            System.out.println(-1);
        }
    }

    static void find1(int n){
        int k = 1;
        for (; k < Integer.MAX_VALUE; k++) {
            long res = k * n;
            if (check(res)){
                System.out.println(res);
                return;
            }
        }
        System.out.println(-1);
    }

    static boolean check(long res){
        String str = String.valueOf(res);
        String str1 = str.replaceAll("[2-9]", "");
        if (str.length() != str1.length()){
            return false;
        }
        return true;
    }

    static boolean isExist(int[][] arr, int k){
        int rows = arr.length;
        int cols = arr[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0){
            if (arr[row][col] > k){
                --col;
            }else if (arr[row][col] < k){
                ++row;
            }else{
                return true;
            }
        }
        return false;
    }

}
