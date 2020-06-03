import java.util.Scanner;

public class Statistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(letterCount(str));
            System.out.println(spaceCount(str));
            System.out.println(digitCount(str));
            System.out.println(otherCount(str));
        }
    }

    public static int letterCount(String str){
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))){
                ++num;
            }
        }
        return num;
    }

    public static int spaceCount(String str){
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i))){
                ++num;
            }
        }
        return num;
    }

    public static int digitCount(String str){
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))){
                ++num;
            }
        }
        return num;
    }

    public static int otherCount(String str){
        return str.length() - letterCount(str) - spaceCount(str) - digitCount(str);
    }
}
