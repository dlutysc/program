package huawei.online_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Java8Test {
    public static void main(String args[]){

        List<String> names1 = new ArrayList<>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        Java8Test tester = new Java8Test();
//        tester.sortUsingJava8(names1);
//        Collections.sort(names1, (s1, s2)->s2.compareTo(s1));

//        Comparator cmp = Collections.reverseOrder();
//        Collections.sort(names1, cmp);

        Collections.sort(names1, Collections.reverseOrder());

        System.out.println(names1);
    }

    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private void sortUsingJava8(List<String> names){
        Collections.sort(names, (s1, s2)->s2.compareTo(s1));
        Collections.sort(names, Comparator.reverseOrder());
    }
}