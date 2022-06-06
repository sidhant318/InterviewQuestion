package DP.General;

import java.util.Arrays;

public class LIS {

	public static void main(String[] args) {
		int arr[]=new int[]{1,5,7,8,3,1,2,3,4,5,9};
		longestSeq(arr,arr.length);
	}

	private static void longestSeq(int[] arr, int length) {
		int tmp[]=new int[length];
		Arrays.fill(tmp, 1);
		int total=1;
		for(int i=1;i<length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					tmp[i]=Math.max(tmp[i], tmp[j]+1);
				}
			}
			total=Math.max(total, tmp[i]);
		}
		System.out.println(total);
	}

}
