package DP.Bounded;

public class SubsetSum {

	public static void main(String[] args) {
		int[] value= {2,3,7,8,10};
		int sum=11;
		SubsetSum k=new SubsetSum();
		int totalValue=k.subsetSum(value,sum);
		System.out.println(totalValue);

	}

	private int subsetSum(int[] value, int sum) {

		int n=value.length;
		int[][] table=new int[n+1][sum+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=sum;j++) {
				if(i==0) {
					table[i][j]=0;
				}
				else if(j==0) {
					table[i][j]=1;
				}
				else if(value[i-1]<=j) {
					table[i][j]=Math.max(table[i-1][j-value[i-1]], table[i-1][j]);
				}
				else {
					table[i][j]=table[i-1][j];
				}
			}
		}
		return table[n][sum];
	}

}
