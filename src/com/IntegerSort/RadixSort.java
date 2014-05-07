package com.IntegerSort;

import java.util.Arrays;

public class RadixSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,2,3,2,5,333,45566,2345678,78,990,12,432,56};  
		int radix = 10;
		int distance = 7;
		radixSort(array, radix, distance);
		
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println();
	}
	
	/**
	 * 使用基数排序对整数数组进行排序，按从小到大的书讯进行排序
	 * @param num 需要进行排序的数组
	 * @param radix 表示基数
	 * @param distance 排序元素的位置
	 */
	private static void radixSort(int[] num, int radix, int distance){

		int length = num.length;	//排序数组长度
		int[] temp = new int[length];	//临时存放数组元素
		int[] count = new int[radix];	//进行统计个数
		int divide = 1;					//除数
		
		
		for(int i=0;i<distance;i++){
			Arrays.fill(count, 0);
			System.arraycopy(num, 0, temp, 0, length);
			for(int j=0;j<length;j++){
				int tempkey = (num[j] /divide) % radix;
				count[tempkey] ++;
			}
			
			for(int j=1;j<radix;j++){
				count[j] = count[j] + count[j-1];
			}
			
			for(int j=length-1;j>=0;j--){	//倒序能够保证稳定性
				int tempkey = (temp[j] /divide) % radix;
				count[tempkey] --;
				num[count[tempkey]] = temp[j];	
			}
			
			//一次长度结束之后，将除数增大
			divide = divide * radix;
		}
		
	}

}
