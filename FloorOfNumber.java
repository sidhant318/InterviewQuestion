package BinarySearch;

public class FloorOfNumber {

	public static void main(String[] args) {
		int[] arr= {2,3,5,9,16,17,18};
		System.out.println(findFloor(arr,15));
	}

	private static int findFloor(int[] arr, int k) {
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=(left+right)/2;
			if(arr[mid]==k)
				return k;
			if(arr[mid]<k) {
				left=mid+1;
			}
			else {
				right=mid-1;
			}
		}
		return arr[right];
	}

}
