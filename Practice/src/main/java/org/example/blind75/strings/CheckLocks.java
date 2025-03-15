package org.example.blind75.strings;

import java.util.*;

public class CheckLocks {
    public static int checkLocks(List<String> events){
//        Stack<String> stack = new Stack<>();
//        int count=0;
//        for(String s: events){
//            String[] splitS = s.split(" ");
//            String op = splitS[0];
//            String num = splitS[1];
//            String curr =  op+num;
//            if(!stack.isEmpty()){
//                String last = stack.peek();
//                if(check(last, curr, num)){
//                    stack.pop();
//                    count++;
//                    continue;
//                }
//            }
//            stack.push(curr);
//        }
//        return count;

        Stack<String> acquiredLocks = new Stack<>();
        for (int i = 0; i < events.size(); i++) {
            String event = events.get(i);
            String[] splitEvent = event.split(" ");
            String operation = splitEvent[0];
            String lockId = splitEvent[1];

            if (operation.equals("ACQUIRE")) {
                if (acquiredLocks.contains(lockId)) {
                    return i + 1;
                }
                acquiredLocks.add(lockId);
            } else if (operation.equals("RELEASE")) {
                if (acquiredLocks.isEmpty() || !acquiredLocks.peek().equals(lockId)) {
                    return i + 1;
                }
                acquiredLocks.remove(lockId);
            }
        }
        if (!acquiredLocks.isEmpty()) {
            return events.size() + 1;
        }
        return 0;
    }
    public static boolean check(String l, String c, String n) {
        return (l.equals("ACQUIRE" + n) && c.equals("RELEASE" + n));
    }

    /*
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
    */

    public static void main(String[] args) {
        System.out.println(checkLocks(Arrays.asList("ACQUIRE 364", "ACQUIRE 84", "RELEASE 364", "RELEASE 84")));
    }
}

