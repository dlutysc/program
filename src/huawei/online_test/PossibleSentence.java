package huawei.online_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PossibleSentence {
    private static List<List<String>> ret = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String dict = sc.nextLine();

            int sBegin = str.indexOf('\"');
            int sEnd = str.lastIndexOf('\"');
            str = str.substring(sBegin + 1, sEnd);

            int dictBegin = dict.indexOf('\"');
            int dictEnd = dict.lastIndexOf('\"');
            dict = dict.substring(dictBegin + 1, dictEnd);
            String[] dicts = dict.split("\",\"");
            List<String> list = new ArrayList<>();
            getSentences(str, dicts, list);
            System.out.println(format(ret));
        }

    }
    static String format(List<List<String>> ret){
        StringBuilder sb = new StringBuilder();
        for (int i = ret.size() - 1; i >= 0; --i){
            if (i != 0){
                for (int j = 0; j < ret.get(i).size(); ++j){
                    if (j != ret.get(i).size() - 1){
                        sb.append(ret.get(i).get(j) + " ");
                    }else {
                        sb.append(ret.get(i).get(j) + ", ");
                    }
                }
            }else {
                for (int j = 0; j < ret.get(i).size(); ++j){
                    if (j != ret.get(i).size() - 1){
                        sb.append(ret.get(i).get(j) + " ");
                    }else {
                        sb.append(ret.get(i).get(j));
                    }
                }
            }

        }
        sb.append(']');
        sb.insert(0, '[');
        return sb.toString();
    }

    static void getSentences(String str, String[] dicts, List<String> list) {
        if (str.isEmpty()) {
            ret.add(new ArrayList<>(list));
        }
        for (int i = 0; i < dicts.length; ++i) {
            if (str.indexOf(dicts[i]) != 0) {
                if (i == dicts.length - 1) {
                    list.clear();
                }
            } else {
                list.add(dicts[i]);
                getSentences(str.substring(dicts[i].length()), dicts, list);
            }
        }
    }
}