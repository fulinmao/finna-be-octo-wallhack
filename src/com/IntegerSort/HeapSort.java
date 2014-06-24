package com.IntegerSort;

/**
 * Created by hadoop on 14-6-18.
 */
public class HeapSort {

    public static void main(String args[]){
        int[] nums={26,5,98,108,28,99,100,56,34,1};
        printArray("排序前：",nums);
        buildMinHeap(nums, nums.length);
        printArray("建立大顶堆：",nums);
        heapSort(nums);
        printArray("排序后：",nums);
    }

    private static void buildMinHeap(int[] nums, int length) {

        for(int i=length/2;i>=0;i--){
            keepHeapBalance(nums,i,length);
        }

    }

    private static void keepHeapBalance(int[] nums, int i, int length) {
        int large = i ;

        int left = getleftChild(i);
        int right = getrightChild(i);

        if(left < length && nums[left] > nums[large]){
            large = left;
        }

        if(right < length && nums[right] > nums[large]){
            large = right;
        }

        if(large !=i){
            exchange(nums,i,large);
            keepHeapBalance(nums,large,length);
        }

    }

    private static void exchange(int[] nums , int i,int large){
        int temp = nums[i];
        nums[i] = nums[large];
        nums[large] = temp;
    }


    private static int getleftChild(int i){
        return i*2 + 1;
    }

    /**
     * 获取i节点的右孩子
     * @param i 从 0开始计
     * @return
     */
    private static int getrightChild(int i){
        return (i+1)*2;
    }




    private static void heapSort(int[] nums) {
        int length = nums.length;
        buildMinHeap(nums,length);
        for(int i=length -1;i>0;i--){
            exchange(nums,0,i);
            keepHeapBalance(nums,0,--length);
        }
    }

    /**
     * 打印数组
     * @param pre print array before print pre
     * @param a The array that will be printed
     */
    private static void printArray(String pre ,int a[]){
        System.out.print(pre+"\n");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }
}
