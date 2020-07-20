package huawei.online_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PinDuoDuo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();
            String line1 = sc.nextLine();
            String[] str1 = line1.split(" ");
            for (int i = 0; i < str1.length; i++) {
                listA.add(Integer.parseInt(str1[i]));
            }
            String line2 = sc.nextLine();
            String[] str2 = line2.split(" ");
            for (int i = 0; i < str2.length; i++) {
                listB.add(Integer.parseInt(str2[i]));
            }

            int index = 0;
            for (int i = 1; i < listA.size(); i++) {
                if (listA.get(i) > listA.get(index)){
                    index = i;
                }else {
                    break;
                }
            }

            boolean flag = false;
            int i;
            for (i = 0; i < listB.size(); i++) {
                if (index > 0 && index + 2 != listA.size()){
                    if (listB.get(i) > listA.get(index - 1) && listB.get(i) < listA.get(index + 1)){
                        flag = true;
                        break;
                    }
                }else if(index == 0){
                    if (listB.get(i) < listA.get(index + 1)){
                        flag = true;
                        break;
                    }
                }else if (index + 2 == listA.size()){
                    if (listB.get(i) > listA.get(index)){
                        flag = true;
                        break;
                    }
                }
            }

            int max = Integer.MIN_VALUE;
            if (flag){
                max = listB.get(i);
                for (int j = i; j < listB.size(); j++) {
                    if (index == 0){
                        if (listB.get(j) > max && listB.get(j) < listA.get(index + 1)){
                            max = listB.get(j);
                        }
                    }else if (index == listA.size() - 2){
                        if (listB.get(j) > max){
                            max = listB.get(j);
                        }
                    }else {
                        if (listB.get(j) > max && listB.get(j) < listA.get(index + 1)){
                            max = listB.get(j);
                        }
                    }

                }
            }

            if (flag){
                if (index + 2 == listA.size()){
                    listA.set(index + 1, max);
                }else {
                    listA.set(index, max);
                }

                for (int j = 0; j < listA.size(); ++j){
                    if (j != listA.size() - 1){
                        System.out.print(listA.get(j) + " ");
                    }else {
                        System.out.print(listA.get(j));
                    }
                }
            }else {
                System.out.println("NO");
            }
        }
    }
}
