package DP.Bounded;

public class EqualSumPartition {

	public static void main(String[] args) {
		int[] value= {2,3,7,8,10};
		EqualSumPartition k=new EqualSumPartition();
		int totalValue=k.equalSumPartition(value);
		System.out.println(totalValue);

	}

	private int equalSumPartition(int[] value) {
		int n=value.length;
		int total=0;
		for(int i=0;i<n;i++) {
			total+=value[i];
		}
		if(total%2!=0) {
			return 0;
		}
		total=total/2;
		return subsetSum(value,total);
	}

	private int subsetSum(int[] value, int total) {
		int n=value.length;
		int[][] table=new int[n+1][total+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=total;j++) {
				if(i==0)
					table[i][j]=0;
				else if(j==0)
					table[i][j]=1;
				else if(value[i-1]<=j) {
					table[i][j]=Math.max(table[i-1][j-value[i-1]], table[i-1][j]);
				}
				else {
					table[i][j]=table[i-1][j];
				}
			}
		}
		return table[n][total];
	}

}
