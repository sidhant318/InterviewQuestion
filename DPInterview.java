import java.util.Arrays;

public class DPInterview {

	public static void main(String[] args) {
		int arr[]= {1,4,0,2,1,3,2,6};
		System.out.println(minTap(arr,arr.length));

	}

	private static int minTap(int[] arr, int length) {
		int[] dp=new int[length];
		Arrays.fill(dp, -1);
		
		int indexLeft;
		int indexRight;
		
		for(int i=0;i<length;i++) {
			indexLeft=Math.max(i-arr[i], 0);
			indexRight=Math.min(i+(arr[i]+1), length);
			dp[indexLeft]=Math.max(dp[indexLeft], indexRight);
		}
		
		Arrays.stream(dp).forEach(a->System.out.print(a));
		int count=1;
		int indexNext=0;
		indexRight=dp[0];
		
		for(int i=0;i<length;i++) {
			indexNext=Math.max(indexNext, dp[i]);
			if(i==indexRight) {
				count++;
				indexRight=indexNext;
			}
		}
		
		return count;
	}

}
