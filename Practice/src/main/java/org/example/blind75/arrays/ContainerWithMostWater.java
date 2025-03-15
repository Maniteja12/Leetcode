package org.example.blind75.arrays;


public class ContainerWithMostWater {
    public static int maxArea(int[] height){
        int i =0;
        int j = height.length-1;
        int max = 0;
        while(i<j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
