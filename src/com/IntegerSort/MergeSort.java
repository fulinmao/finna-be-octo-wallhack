package com.sort;

import java.util.Queue;

/**
 * Created by hadoop on 14-6-17.
 */
public class MergeSort<T extends Comparable<T>>{
    static int number=0;
    public static void main(String args[]){

        int[] nums={26,5,98,108,28,99,100,56,34,1};
        printArray("排序前：",nums);
        MergeSort(nums);
        printArray("排序后：",nums);
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

    public static void MergeSort(int[] a){
        System.out.println("start sorting:");

        Sort(a,0,a.length-1);
    }

    private static void Sort(int[] a, int left, int right) {
        if (left >=right){
            return;
        }

        int mid = (left + right) /2 ;
        Sort(a,left,mid);
        Sort(a,mid+1,right);
        merge(a,left,mid,right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int tmp[]  = new int[a.length];
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex=left;
        // 逐个归并
        while(left <=mid && r1 <= right) {
            if (a[left] <= a[r1])
                tmp[tIndex++] = a[left++];
            else
                tmp[tIndex++] = a[r1++];
        }
        // 将左边剩余的归并
        while (left <=mid) {
            tmp[tIndex++] = a[left++];
        }
        // 将右边剩余的归并
        while ( r1 <= right ) {
            tmp[tIndex++] = a[r1++];
        }




        System.out.println("第"+(++number)+"趟排序:\t");
        // TODO Auto-generated method stub
        //从临时数组拷贝到原数组
        while(cIndex<=right){
            a[cIndex]=tmp[cIndex];
            //输出中间归并排序结果
            System.out.print(a[cIndex]+"\t");
            cIndex++;
        }
        System.out.println();
    }
}
