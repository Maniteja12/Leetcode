package org.example.blind75.strings;
import java.util.Stack;

public class CheckParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(!stack.isEmpty()){
                char last = stack.peek();
                if(check(last,curr)){
                    stack.pop();
                    continue;
                }
            }stack.push(curr);
        }
        return stack.isEmpty();
    }
    public static boolean check(char l, char c){
        return ((l == '{' && c == '}') ||
                (l == '(' && c == ')') ||
                (l == '[' && c == ']'));
    }
    public static void main(String[] args) {
        System.out.println(isValid("{([])}"));
    }
}
