package org.example.sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortByAlgorithm {
    public static int[] selectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(min, i, arr);
        }
        return arr;
    }
    private static void swap(int i1, int i2, int[] arr) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    public static int[] bubbleSort(int[] arr){
        for(int i=arr.length-1;i>=0;i--){
            int flag =0;
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(j,j+1, arr);
                    flag=1;
                }
            }
            if(flag == 0)
                break;
        }
        return arr;
    }
    public static void bubbleSortRecursion(int[] arr, int n){
        if(n == 1) return;
        int didSwap =0;
        for(int j=0;j<=n-2;j++){
            if(arr[j] > arr[j+1]) {
                swap(j, j + 1, arr);
                didSwap=1;
            }
        }
        if(didSwap == 0) return;
        bubbleSortRecursion(arr, n-1);
    }
    public static int[] insertionSort(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            int j=i;
            while(j>0 && arr[j-1] > arr[j]){
                swap(j-1,j,arr);
                j--;
            }
        }
        return arr;
    }
    public static void mergeSort(int[] arr, int low, int high){
        if(low >= high) return;
        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right=mid+1;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<= high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low;i<= high;i++){
            arr[i] = temp.get(i-low);
        }
    }
    public static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot);
            quickSort(arr, pivot+1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i=low, j=high;
        while(i<j){
            while(arr[i] <= pivot && i<= high-1){
                i++;
            }while(arr[j] >= pivot && j >= low+1){
                j--;
            }
            if(i<j){
                swap(i,j,arr);
            }
        }
        swap(low,j,arr);
        return j;
    }

    public static void main(String[] args) {
       // System.out.println(Arrays.toString(/*insertionSort(new int[]{3,8,1,5,6,7,2,9,4}))); */insertionSort(new int[]{1,2,3,4,5,6})));
        int n=7;
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        System.out.println("Before sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //mergeSort(arr, 0, n - 1);
        //quickSort(arr, 0, n - 1);
        bubbleSortRecursion(arr, n);
        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
