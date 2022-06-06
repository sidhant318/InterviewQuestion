package String;

import java.util.Arrays;

public class CountTriplet {

	public static void main(String[] args) {
		int arr[] = {1, 5, 3, 2};
		System.out.println(countTriplet(arr));

	}

	private static int countTriplet(int[] arr) {
		int count=0;
		Arrays.sort(arr);
		for(int i=0;i<arr.length-2;i++) {
			int k=arr.length-1;
			for(int j=arr.length-2;j>i;j--) {
				if(arr[i]+arr[j]<arr[k]) {
					k=k-1;
				}
				if(arr[i]+arr[j]==arr[k]) {
					count++;
					k--;
				}
			}
		}
		
		return count;
	}

}
