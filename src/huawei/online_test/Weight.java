package huawei.online_test;

import java.util.*;

/**
 * 华为机试：称砝码
 */
public class Weight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int weightNum = sc.nextInt();
            int[] weight = new int[weightNum];
            int[] nums = new int[weightNum];
            for (int i = 0; i < weightNum; i++) {
                weight[i] = sc.nextInt();
            }
            for (int i = 0; i < weightNum; i++) {
                nums[i] = sc.nextInt();
            }
            //求出第一个砝码所能表示的质量，放入集合中
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i <= nums[0]; ++i){
                set.add(i * weight[0]);
            }
            //求第二个砝码以及之后的每个砝码所能表示的质量，每一次的结果都添加到集合中
            for (int i = 1; i < weight.length; i++) {
                int[] arr = new int[nums[i] + 1];
                for (int j = 0; j <= nums[i]; j++) {
                    arr[j] = j * weight[i];
                }

                Object[] objs = set.toArray();
                for (int j = 0; j < objs.length; ++j){
                    for (int k = 0; k < arr.length; k++) {
                        set.add((int)objs[j] + arr[k]);
                    }
                }
            }
            System.out.println(set.size());
        }
        sc.close();
    }
}
