import com.sun.deploy.util.StringUtils;
import javafx.util.Pair;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
//        int i;
//        i = 1 << 3;
//        int j = 9;
//        System.out.println(Integer.toBinaryString(j));
//        j >>>= 4;
//        System.out.println(j);
//        System.out.println(0xff);
//        System.out.println("10.2.3".split("\\."));
//        System.out.println(i << 1);
//        System.out.println(Math.floor(-11.6));
//        System.out.println(Math.floor(-11.4));
//        System.out.println(Math.floor(11.6));
//        System.out.println(Math.floor(11.2));
//        System.out.println(Math.ceil(11.6));
//        System.out.println(Math.ceil(11.2));
//        System.out.println(Math.ceil(-11.2));
//        System.out.println(Math.ceil(-11.6));
//        System.out.println(Math.round(-11.1));
//        System.out.println(Math.round(-11.6));
//        System.out.println(Math.round(11.2));
//        System.out.println(Math.round(11.6));
//        System.out.println("***********");
//        Random r = new Random();
//        for (int k = 0; k < 20; k++) {
//            System.out.println(r.nextInt(10));
//        }
//
//        String[] strArr = new String[4];
//        strArr[0] = "ww";
//        strArr[1] = "";
//        System.out.println(Arrays.toString(strArr));
//
//        ArrayList list = new ArrayList();
//        list.add(3);
//        System.out.println(list);
//        StringBuilder sb = new StringBuilder();
//
//        int[][] arr = new int[3][5];
//        System.out.println(arr.length);
//        System.out.println(arr[0].length);
//        Scanner sc = new Scanner(System.in);
//        for (int j = 0; j < arr.length; j++) {
//            for (int k = 0; k < arr[0].length; k++) {
//                arr[j][k] = sc.nextInt();
//            }
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//
//        for (int j = 0; j < arr.length; j++) {
//            for (int k = 0; k < arr[0].length; k++) {
//                if (k != arr[0].length - 1){
//                    System.out.print(arr[j][k] + " ");
//                }else {
//                    System.out.print(arr[j][k] + "\n");
//                }
//            }
//        }
//
//        for(int[] a : arr){
//            for (int i : a){
//                System.out.print(i + " ");
//            }
//        }
//
//        Date date = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.DATE, - 1);
//        date = calendar.getTime();
//        System.out.println(date);
//
        String str = "我是谁A";
        try {
            System.out.println(Arrays.toString(str.getBytes("GBK")));
        }catch (Exception e){
            e.getMessage();
        }
        System.out.println(Character.isDigit('4'));
        System.out.println(-4/2);
        String s1 = "abc";
        String s2 = "\"deabf\"";
        System.out.println(s2.indexOf(s1));
        System.out.println(s2.lastIndexOf('\"'));
        List<List<String>> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("ad");

        String ss = "1234";
        HashMap<Integer, String> map = new HashMap<>();
        test(list1, ss, map);

        System.out.println(list1);
        System.out.println(ss);
        System.out.println(map);
//        List<String> item = new ArrayList<>(list1);
//        item.addAll(list1);
//        list.add(item);
//        list1.clear();
//        System.out.println(list);

        int a =100,b=50,c=a---b,d=a---b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        Integer e = 500;
        Integer f = 500;
        System.out.println(f == e);

        String str1 = "";
        System.out.println(str1.split(",").length);
        System.out.println(Arrays.toString(str1.split(",")));

        Integer count = new Integer(500);
        test1(count);
        System.out.println(count);

        String string = "  ab c  ";
        System.out.println(string.length());
        string = string.replaceAll("^\\s+|\\s+$", "");
        System.out.println(string.length());

        List<String> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
//        res.add("1");
//        String left = "abc";
//        for (String s : res){
//            ans.add(left + s);
//        }
//        System.out.println(ans);
        res.add("a");
        res.add("b");
        res.add("c");
        System.out.println(res);
        Collections.reverse(res);
        System.out.println(res);

        System.out.println(-3 + (-2));

        boolean[] array = new boolean[3];
        array[0] = true;
        System.out.println(Arrays.toString(array));

        System.out.println(digitSum(135));
        int time = 0;
        for (int i = 1; i >= 0 ; i = i + i) {
            ++time;
            System.out.println(i);
        }
        System.out.println(Math.pow(2, 31) - 1 == Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(time);

        String str22 = "hello\0";
        char[] chars = str22.toCharArray();
        System.out.println(str22);
        System.out.println(Arrays.toString(chars));
        System.out.println(chars.length);
        Object object = 'j';
        float ff = 10.9f;
        char s = '\u0639';
        System.out.println(s);
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(null, 1);
        map1.put(null, 4);
        map1.put(1, null);
        map1.put(2, null);
        System.out.println(map1.size());
        System.out.println(map1.get(null));
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(map1.values());
        Integer[] array1 = new Integer[list2.size()];
        list2.toArray(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println(list2);
        list2.contains(4);
        Object obj = 4;
        list2.remove(obj);
        System.out.println(list2);
        System.out.println(list2.getClass().getName());

        StringBuilder sb = new StringBuilder();
        test2(sb);
        System.out.println(sb);

        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 5; i >= 0; i--) {
            left.add(i);
        }
        System.out.println(left.peek());

        System.out.println(5 / 2.0);
        System.out.println((double) (5 / 2));

        Pair<Integer, Integer> pair = new Pair<>(1, 2);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());

        String object1 = null;
        try {
            object1 = (String) Class.forName("String").getConstructor(String.class).newInstance("hello");
        } catch (Exception e1){
            e1.getMessage();
        }
        System.out.println(object1);

        int[][] a1 = null;
        System.out.println(a1 == null);
//        System.out.println(a1.length);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        System.out.println(list3.remove(0));

        StringBuilder sb1 = new StringBuilder("avc");
        test2(sb1);
        System.out.println(sb1);
    }

    static void test2(StringBuilder sb){
        sb.append(1);
    }
    static void test(List<String> list, String s, HashMap<Integer, String> hashMap){
        ArrayList<String> lst = new ArrayList<>();
        lst.addAll(list);
        lst.clear();
        s.replace('1', '2');
        hashMap.put(1, "val");
    }

    static void test1(Integer integer){
        ++integer;
    }

    static int digitSum(int num){
        int sum = 0;
        while (num != 0){
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

}
