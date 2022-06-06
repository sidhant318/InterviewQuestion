package BinarySearch;

public class BinarySearchTest {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8};
		System.out.println(search(arr,8));

	}

	private static boolean search(int[] arr,int k) {
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=(left+right)/2;
			if(arr[mid]==k)
				return true;
			if(arr[mid]<k) {
				left=mid+1;
			}
			else {
				right=mid-1;
			}
		}
		return false;
	}

}
