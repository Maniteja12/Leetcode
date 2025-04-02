package org.example.blind75.arrays;

public class FindDuplicateWithConstantSpace {
    public static int findDuplicate(int[] arr){
        for(int i=0;i<arr.length;i++){
            int index = Math.abs(arr[i]-1);
            if(arr[index] < 0){
                return arr[i];
            }
            arr[index] = -arr[index];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,2,2}));
    }
}
