package DP.General;

public class CoinChange {

	public static void main(String[] args) {
		int arr[]=new int[] {1,2};
		int num=4;
		int val=cal(arr,num);
System.out.println(val);
	}

	private static int cal(int[] arr, int num) {
		int tmp[]=new int[num+1];
		tmp[0]=1;
		for(int i=0;i<arr.length;i++) {
			for(int j=arr[i];j<=num;j++) {
				tmp[j]=tmp[j]+tmp[j-arr[i]];
			}
		}
		return tmp[num];
	}

}

