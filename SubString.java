package DP.Bounded;

public class SubString {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8,9,10};
		int sum=24;
		int val=subStringFind(arr,arr.length,sum);
		System.out.println(val);
	}

	private static int subStringFind(int[] arr, int size, int sum) {
		int[][] table=new int[size+1][sum+1];
		for(int i=0;i<=size;i++) {
			for(int j=0;j<=sum;j++) {
				if(i==0) {
					table[i][j]=0;
				}
				else if(j==0) {
					table[i][j]=1;
				}
			}
		}
		for(int i=1;i<=size;i++) {
			for(int j=1;j<=sum;j++) {
				if(arr[i-1]<=j) {
					table[i][j]=Math.max(table[i - 1][j - arr[i - 1]] , table[i - 1][j]);
				}
				else {
					table[i][j]=table[i-1][j];
				}
			}
		}
		return table[size][sum];
	}

}
