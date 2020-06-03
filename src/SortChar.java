import java.util.Arrays;
import java.util.Scanner;

public class SortChar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.nextLine();
            System.out.println(s);
            char[] chArr = s.toCharArray();
            Arrays.sort(chArr);
//            System.out.println(new String(chArr));
            System.out.println(chArr);
        }
    }
}
