package org.example.amazon;

import java.util.Stack;

public class SimplifyPath {
    public static String solution(String path){
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String c: components){
            if(c.equals("") || c.equals("."))
                continue;
            else if(c.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else
                stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,"/" + stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("/.../a/../b/c/../d/./"));
    }
}
