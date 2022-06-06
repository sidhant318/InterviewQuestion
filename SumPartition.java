package DP.Bounded;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumPartition {
static int count=0;
	public static void main(String[] args) {
	}

	private static int SumPartitionFind(int[] arr, int length) {
		int val=0;
		for(int i=0;i<length;i++) {
			val+=arr[i];
		}
		int sum=val/2;
		int[][] table=new int[length+1][sum+1];
		if(val%2!=0) {
			return 0;
		}
		else {
			
			for(int i=0;i<=length;i++) {
				for(int j=0;j<=sum;j++) {
					if(i==0) {
						table[i][j]=0;
					}
					else if(j==0){
						table[i][j]=1;
					}
				}
			}
			for(int i=1;i<=length;i++) {
				for(int j=1;j<=sum;j++) {
					if(arr[i-1]<=j) {
						table[i][j]=Math.max(table[i-1][j-arr[i-1]], table[i-1][j]);
					}
					else {
						table[i][j]=table[i-1][j];
					}
				}
			}
		}
		return table[length][sum];
	}

}
