import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JoinString {
    private static final String helper1 = "0123456789abcdefABCDEF";
    private static final String helper2 = "084C2A6E195D3B7F5D3B7F";
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next() + in.next();
            System.out.println(str);
            ArrayList<Character> evenLst = new ArrayList<Character>();
            ArrayList<Character> oddLst = new ArrayList<Character>();
            for (int i = 0; i < str.length(); ++i){
                if (i % 2 == 0){
                    oddLst.add(str.charAt(i));
                }else {
                    evenLst.add(str.charAt(i));
                }
            }
            Collections.sort(evenLst);
            Collections.sort(oddLst);
            StringBuilder sb = new StringBuilder();
            for (int i = 0, j = 0, k = 0; i < str.length(); ++i){
                if (i % 2 == 0){
                    sb.append(oddLst.get(j));
                    ++j;
                }else {
                    sb.append(evenLst.get(k));
                    ++k;
                }
            }
            System.out.println(sb.toString());
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < sb.length(); ++i){
                int n = helper1.indexOf(sb.charAt(i));
                if (n != -1){
                    res.append(helper2.charAt(n));
                }else {
                    res.append(sb.charAt(i));
                }
            }
            System.out.println(res.toString());
        }
    }
}
