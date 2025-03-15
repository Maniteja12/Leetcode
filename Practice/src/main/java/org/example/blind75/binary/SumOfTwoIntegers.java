package org.example.blind75.binary;

public class SumOfTwoIntegers {
    public static int getSum(int a, int b) {
        return b==0? a: getSum(a^b, (a&b)<<1);
    }
    /*
    if a=2 and b=3; first round a becomes 2 and b becomes 2, next round 2 becomes 2 and b becomes 4
    XOR of 2 and 4 gives 5.
     */
    public static void main(String[] args) {
        System.out.println(getSum(2,4));
    }
}
