package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static String addSpaces(String s, int[] spaces) {

        StringBuilder sb = new StringBuilder();
        int index =0;
        for(int i : spaces){
            sb.append(s.substring(index , i)).append(" ");
            index = i;
        }
        sb.append(s.substring(index , s.length()));
        return sb.toString();
    }

    public static void main(String[] args) {
        String result = addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13,15});
        System.out.println(result);
    }
}