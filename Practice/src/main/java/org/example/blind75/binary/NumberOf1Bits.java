package org.example.blind75.binary;

public class NumberOf1Bits {
    public static int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                res += 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(hammingWeight(2147483645));
    }
}
