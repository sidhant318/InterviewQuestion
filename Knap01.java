package DP.Bounded;

public class Knap01 {

	public static void main(String[] args) {
		int[] weight= {10,20,30};
		int[] value= {60,100,120};
		int totalWeight=50;
		Knap01 k=new Knap01();
		int totalValue=k.knapshak(weight,value,totalWeight);
		System.out.println(totalValue);
	}

//	private int knapshak(int[] weight, int[] value, int totalWeight) {
//		int n=value.length;
//		int[][] table=new int[n+1][totalWeight+1];
//		for(int i=0;i<=n;i++) {
//			for(int j=0;j<=totalWeight;j++) {
//				if(i==0 || j==0) {
//					table[i][j]=0;
//				}
//				else if(weight[i-1]<=j) {
//					table[i][j]=Math.max(value[i-1]+table[i-1][j-weight[i-1]], table[i-1][j]);
//				}
//				else {
//					table[i][j]=table[i-1][j];
//				}
//			}
//		}
//		return table[n][totalWeight];
//		
//	}
	
	private int knapshak(int[] weight, int[] value, int totalWeight) {
		int n=value.length;
		int[] table=new int[totalWeight+1];
		for(int i=1;i<=n;i++) {
			for(int j=totalWeight;j>=0;j--) {
				if(weight[i-1]<=j) {
					table[j]=Math.max(value[i-1]+table[j-weight[i-1]], table[j]);
				}
			}
		}
		return table[totalWeight];
		
	}

}
