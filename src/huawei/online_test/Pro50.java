package huawei.online_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Pro50 {
    private static Stack<Character> ops = new Stack<>();
    private static List<Integer> numcnt = new ArrayList<>();
    private static Stack<Integer> nums = new Stack<>();

    public static int calculate(String expression){
        int index = 0;
        int length = expression.length();
        for(int i = 0; i < length; i++){
            char item = expression.charAt(i);
            if(isNum(item)){
                int total = 0;
                int count = numcnt.get(index);
                while(count-- > 0)
                    total = total * 10 + (expression.charAt(i++) - '0');
                i--;
                nums.push(total);
                index++;
            }
            else{
                char op = item;
                int num = nums.pop();
                switch(op){
                    case '+': num = nums.pop() + num;break;
                    case '-': num = nums.pop() - num;break;
                    case '*': num = nums.pop() * num;break;
                    case '/': num = nums.pop() / num;break;
                }
                nums.push(num);
            }
        }
        return nums.pop();
    }

    private static boolean isNum(char ch){
        return ch >= '0' && ch <= '9';
    }

    public static String getTailExpression(String s){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char item = s.charAt(i);
            if(isNum(item)){
                int count = 0;
                do{
                    count++;
                    result.append(s.charAt(i++));
                }while(i < s.length() && isNum(s.charAt(i)));
                i--;
                numcnt.add(count);
            }
            else if(item == '+' || item == '-'){
                if(item == '-' && (i == 0 || s.charAt(i - 1) == '(' || s.charAt(i - 1) == '[' || s.charAt(i - 1) == '}')){
                    result.append(0);
                    numcnt.add(1);
                }
                while(!ops.isEmpty() && (ops.peek() == '+' || ops.peek() == '-' || ops.peek() == '*' || ops.peek() == '/')){
                    result.append(ops.pop());
                }
                ops.push(item);
            }
            else if(item == '*' || item == '/'){
                while(!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')){
                    result.append(ops.pop());
                }
                ops.push(item);
            }
            else if(item == '(' || item == '[' || item == '{')
                ops.push(item);
            else if(item == ')'){
                while(ops.peek() != '(')
                    result.append(ops.pop());
                ops.pop();
            }
            else if(item == ']'){
                while(ops.peek() != '[')
                    result.append(ops.pop());
                ops.pop();
            }
            else if(item == '}'){
                while(ops.peek() != '{')
                    result.append(ops.pop());
                ops.pop();
            }
            else
                System.out.println("Invalid input!");
        }
        while(!ops.isEmpty())
            result.append(ops.pop());
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String s = input.nextLine();
            String tailExpression = getTailExpression(s);
//            System.out.println(tailExpression);
//            System.out.println(numcnt);
            int result = calculate(tailExpression);
            System.out.println(result);
        }
    }

}

