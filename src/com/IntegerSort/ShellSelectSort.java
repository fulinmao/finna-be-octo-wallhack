package com.IntegerSort;

/**
 * Created by hadoop on 14-6-23.
 */
public class ShellSelectSort {
    public static void main(String args[]){
        int[] nums={26,5,98,108,28,99,100,56,34,1};
        printArray("排序前：", nums);
        shellSort(nums);
        printArray("排序后：",nums);
    }

    private static void shellSort(int[] nums) {
        int h =1;
        int length = nums.length;

        //计算相应的H值
        while(h<=length/3){
            h = h * 3 + 1;
        }
        while(h>0){
            for(int i=h;i<length;i=i+h){
                if(nums[i] < nums[i-h]){
                    int temp = nums[i];
                    int j=i-h;
                    while(j>=0 && nums[j] > temp){
                        nums[j+1] = nums[j];
                        j = j -h;
                    }

                    nums[j+h] = temp;
                }
            }

            h = (h-1) /3 ;
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
