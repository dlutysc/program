import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 华为机试：名字的漂亮程度
 */
public class BeautyName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            String[] strings = new String[num];
            for (int i = 0; i < num; i++) {
                strings[i] = sc.next(); //不能是nextLine
            }

            for (int i = 0; i < num; i++) {
                HashMap<Character, Integer> map;
                String str = strings[i];
                map = getChTimes(str);
                Integer[] ints = new Integer[map.size()]; //数组必须是Integer类型的
                map.values().toArray(ints);
                Arrays.sort(ints);
                int sum = 0;
                for (int j = ints.length - 1, k = 26; j >= 0; j--) {
                    sum += (ints[j] * k--);
                }
                System.out.println(sum);
            }

        }
    }

    public static HashMap<Character, Integer> getChTimes(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < str.length(); j++) {
            Integer count = map.get(str.charAt(j)); //必须是Integer，如果是int就出现异常,因为不能把null赋值给int
            if (map.get(str.charAt(j)) == null){
                map.put(str.charAt(j), 1);
            }else {
                map.put(str.charAt(j), ++count);
            }
        }
        return map;
    }
}
