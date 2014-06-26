package com.IntegerSort;

/**
 * Created by hadoop on 14-6-26.
 */
public class QuickSort {

    public static void main(String args[]){
        int[] nums={26,5,98,108,28,99,100,56,34,1};
        printArray("排序前：",nums);
        quickSort(nums);
        printArray("排序后：",nums);
    }

    private static void quickSort(int[] nums) {
        int length = nums.length;
        quick(nums,0,length-1);
    }

    private  static void quick(int[] nums, int start,int end){
        if(start < end){
            int pivot = getPivot(nums,start,end);
            System.out.println(pivot);
            quick(nums,start,pivot-1);
            quick(nums,pivot+1,end);
        }
    }

    private static int getPivot(int[] nums,int start ,int end){
        int pivot = start;
        int temp = nums[pivot];
        while(start < end){
            while(start < end && nums[end] > temp){
                end--;
            }

            nums[start] = nums[end];
            while(start < end && nums[start]<=temp){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = temp;
        pivot = start;
        return pivot;
    }

    private static void printArray(String pre, int[] nums) {
        System.out.print(pre+"\n");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
        }
        System.out.println();
    }
}
