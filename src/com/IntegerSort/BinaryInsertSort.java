package com.sort;

/**
 * Created by hadoop on 14-6-19.
 */
public class BinaryInsertSort {
    public static void main(String args[]){
        int[] nums={26,5,98,108,28,99,100,56,34,1};
        printArray("排序前：",nums);
        binInsertSort(nums);
        printArray("排序后：",nums);
    }

    private static void binInsertSort(int[] nums) {
        int length = nums.length;
        int temp = 0;
       for(int i=1;i<length;i++){
           temp = nums[i];
           int low = 0;
           int high = i-1;
            while(low <= high){
               int  mid = (low + high) / 2;
               if(temp >= nums[mid]){
                    low = mid + 1;
               }else{
                    high = mid -1;
               }
            }
           for(int j = i-1;j>high; j--){
               nums[j+1] = nums[j];
           }
           nums[high+ 1] = temp;
       }
    }

    private static void printArray(String pre, int[] nums) {
        System.out.print(pre+"\n");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
        }
        System.out.println();
    }
}
