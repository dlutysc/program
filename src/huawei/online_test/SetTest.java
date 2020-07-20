package huawei.online_test;

import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> subSet;
        for(int i=606;i<613;i++){
            if(i%2==0){
                set.add(i);
            }
        }
        subSet = (TreeSet) set.subSet(608,true,612,false);
        set.add(629);
        System.out.println(set+" "+subSet);
    }

}
