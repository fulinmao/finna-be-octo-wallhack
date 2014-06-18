package com.sort;

/**
 * Created by hadoop on 14-6-18.
 */
public class SimpleSelectSort {

    public static void main(String args[]){
        int[] nums={26,5,98,108,28,99,100,56,34,1};
        printArray("排序前：",nums);
        simpleSelectSort(nums);
        printArray("排序后：",nums);
    }

    private static void simpleSelectSort(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
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
