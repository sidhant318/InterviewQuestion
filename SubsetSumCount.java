package DP.Bounded;

public class SubsetSumCount {

	public static void main(String[] args) {
		int[] value= {2,3,5,6,8,10};
		int sum=10;
		SubsetSumCount k=new SubsetSumCount();
		int totalValue=k.subsetSumCount(value,sum);
		System.out.println(totalValue);

	}

	private int subsetSumCount(int[] value, int sum) {
		int n=value.length;
		int[][] table=new int[n+1][sum+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=sum;j++) {
				if(i==0)
					table[i][j]=0;
				if(j==0)
					table[i][j]=1;
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				if(value[i-1]<=j) {
					table[i][j]=table[i-1][j-value[i-1]]+table[i-1][j];
				}
				else {
					table[i][j]=table[i-1][j];
				}
			}
		}
		return table[n][sum];
	}

}
