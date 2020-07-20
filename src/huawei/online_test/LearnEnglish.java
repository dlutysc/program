package huawei.online_test;

import java.util.Scanner;

/**
 * 华为机试：学英语
 */
public class LearnEnglish {
    public static String[] helper1 = {"", "one", "two", "three", "four", "five"
            , "six", "seven", "eight", "nine", "", "eleven", "twelve", "thirteen"
            , "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static String[] helper2 = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long num = sc.nextLong();
            System.out.println(parse(num));
        }
        sc.close();
    }

    public static String parse(long num){
        if (num < 0){
            return "error";
        }

        String str = String.valueOf(num);
        int numLen = str.length();
        //两位数
        if (numLen == 2){
           return transTwo(num);
        }
        //三位数
        if (numLen == 3){
           return transThree(num);
        }
        //四位数
        if (numLen == 4){
            return transFour(num);
        }
        //五位数
        if (numLen == 5){
            return transFive(num);
        }
        //六位数
        if (numLen == 6){
            return transSix(num);
        }
        //七位数
        if (numLen == 7){
            return transSeven(num);
        }else if (numLen == 8){
            return transEight(num);
        }else{
            return transNine(num);
        }
    }

    public static String transTwo(long num){
        int digit2 = (int) (num / 10);
        int digit1 = (int) (num % 10);
        if (digit2 == 0){
            return helper1[digit1];
        }else {
            if (digit1 == 0){ //整几十
                return helper2[digit2];
            }else {
                return num < 20 ? helper1[(int) num] : helper2[digit2] + " " +  helper1[digit1];
            }
        }

    }
    //整百
    public static String transThree(long num){
        int digit3 = (int)(num / 100);
        if (digit3 == 0){
            return transTwo(num);
        }else {
            String frontOne =  helper1[digit3] + " " +  "hundred";
            if (num % 100 == 0){
                return frontOne;
            }else {
                String backTwo = transTwo(num - digit3 * 100);
                return frontOne + " " + "and" + " " + backTwo;
            }
        }

    }
    //整千
    public static String transFour(long num){
        int[] digits = getDigits(5, num);

        if (digits[4] == 0){
            return transThree(num);
        }else {
            String frontOne = helper1[digits[4]] + " " +  "thousand";
            if (num % 1000 == 0){
                return frontOne;
            }else {
                String backThree = transThree(num - digits[4] * 1000);
                return frontOne + " " + backThree;
            }
        }
    }

    public static String transFive(long num){
        int[] digits = getDigits(6, num);

        if (digits[5] == 0){
            return transFour(num);
        }else {
            String frontTwo = transTwo(digits[5] * 10 + digits[4]) + " thousand ";
            if (num % 1000 == 0){
                return frontTwo;
            }else {
                String backThree = transThree(digits[3] * 100 + digits[2] * 10 + digits[1]);
                return frontTwo + backThree;
            }
        }
    }

    public static String transSix(long num){
        int[] digits = getDigits(7, num);
        if (digits[6] == 0){
            return transFive(num);
        }else {
            String frontThree = transThree(digits[6] * 100 + digits[5] * 10 + digits[4]) + " thousand ";
            if (num % 1000 == 0){
                return frontThree;
            }else {
                String backThree = transThree(digits[3] * 100 + digits[2] * 10 + digits[1]);
                return frontThree + backThree;
            }
        }
    }
    //整百万
    public static String transSeven(long num){
        int[] digits = getDigits(8, num);
        if (digits[7] == 0){
            return transSix(num);
        }else {
            String frontOne = helper1[digits[7]] + " million";
            if (num % 1000000 == 0){
                return frontOne;
            }else {
                String backSix = transSix(num - digits[7] * 1000000);
                return frontOne + " " + backSix;
            }
        }
    }

    public static String transEight(long num){
        int[] digits = getDigits(9, num);
        if (digits[8] == 0){
            return transSeven(num);
        }else {
            int front2Num = digits[8] * 10 + digits[7];
            String frontTwo = transTwo(front2Num) + " million";
            if (num % 1000000 == 0){
                return frontTwo;
            }else {
                String backSix = transSix(num - front2Num * 1000000);
                return frontTwo + " " + backSix;
            }
        }
    }

    public static String transNine(long num){
        int[] digits = getDigits(10, num);
        if (digits[9] == 0){
            return transEight(num);
        }else {
            int front3Num = digits[9] * 100 + digits[8] * 10 + digits[7];
            String frontThree = transThree(front3Num) + " million";
            if (num % 1000000 == 0){
                return frontThree;
            }else {
                String backSix = transSix(num - front3Num * 1000000);
                return frontThree + " " + backSix;
            }
        }
    }


    /**
     * 求数值每一个位的数
     * @param n
     * @param num
     * @return 数组
     */
    public static int[] getDigits(int n, long num){
        int[] digits = new int[n];
        digits[0] = 0;
        int i = 1;
        while (i <= n - 1){
            digits[i] = (int) (num % 10);
            num = num / 10;
            ++i;
        }
        return digits;
    }
}
