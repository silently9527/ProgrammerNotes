package cn.silently9527.basic;

import cn.silently9527.basic.stack.LinkedListStack;
import cn.silently9527.basic.stack.Stack;

public class Evaluate {

    public static int calculate(String expression) {
        Stack<String> operate = new LinkedListStack<>();
        Stack<Integer> numbers = new LinkedListStack<>();

        String[] split = expression.split(" ");
        for (String str : split) {
            if ("(".equals(str)) {
            } else if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
                operate.push(str);
            } else if (")".equals(str)) {
                String op = operate.pop();
                int resut = 0;
                if ("+".equals(op)) {
                    resut = numbers.pop() + numbers.pop();
                } else if ("-".equals(op)) {
                    resut = numbers.pop() - numbers.pop();
                } else if ("*".equals(op)) {
                    resut = numbers.pop() * numbers.pop();
                } else if ("/".equals(op)) {
                    resut = numbers.pop() / numbers.pop();
                }
                numbers.push(resut);
            } else {
                numbers.push(Integer.valueOf(str));
            }
        }
        return numbers.pop();
    }


}
