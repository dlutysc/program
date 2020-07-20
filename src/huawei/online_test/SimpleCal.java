package huawei.online_test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 华为机试：四则运算
 */
public class SimpleCal {
    private static Stack<Character> stack = new Stack<>();
    private static StringBuilder postFix = new StringBuilder();
    private static ArrayList<Integer> digitCnt = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String postFix = trans(str);
            int res = cal(postFix);
            System.out.println(res);
        }
    }

    static String  trans(String inFix){
        char[] chars = inFix.toCharArray();
        for (int i = 0; i < chars.length; ++i){
            if (chars[i] >= '0' && chars[i] <= '9'){
                int temp = 0;
                while (i < chars.length && chars[i] >= '0' && chars[i] <= '9'){ //注意添加i < chars.length
                    postFix.append(chars[i]);
                    ++i;
                    ++temp;
                }
                --i;
                digitCnt.add(temp);
            } else if (chars[i] == '+' || chars[i] == '-'){
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-')){
                    postFix.append( stack.pop());
                }
                stack.push(chars[i]);
            }else if (chars[i] == '*' || chars[i] == '/'){
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')){
                    postFix.append( stack.pop());
                }
                stack.push(chars[i]);
            }else {
                while (!stack.isEmpty()){
                    postFix.append( stack.pop());
                }
            }
        }
        while (!stack.isEmpty()){
            postFix.append(stack.pop());
        }
        return postFix.toString();
    }

    static int cal(String postFix){
        int index = 0;
        Stack<Integer> stack1 = new Stack<>();
        char[] chas = postFix.toCharArray();
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] >= '0' && chas[i] <= '9'){
                int total = 0;
                int cnt = digitCnt.get(index);
                while (cnt-- > 0){
                    total = 10 * total + (chas[i++] - '0');
                }
                --i;
                stack1.push(total);
                ++index;
            }else {
                int num1 = stack1.pop();
                int num2 = stack1.pop();
                if (chas[i] == '+'){
                    stack1.push(num1 + num2);
                }else if (chas[i] == '-'){
                    stack1.push(num2 - num1);
                }else if (chas[i] == '*'){
                    stack1.push(num1 * num2);
                }else {
                    stack1.push(num2 / num1);
                }
            }
        }
        return stack1.peek();
    }

}
