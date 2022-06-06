package BinarySearch;

public class RotatedBinarySearch {

	public static void main(String[] args) {
		int[] arr= {3,4,5,6,8,8,9,1,2};
		//int[] arr= {2,9,2,2,2};
		System.out.println(findElement(arr,1));
	}

	private static boolean findElement(int[] arr, int i) {
		int index=findPivot(arr);
		return (findElement(arr,0,index,i) || findElement(arr,index+1,arr.length-1,i));

	}

	private static boolean findElement(int[] arr, int left, int right,int k) {
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

	private static int findPivot(int[] arr) {
		int left=0;
		int right=arr.length-1;
		while(left<right) {
			int mid=(left+right)/2;
			if(arr[mid]>arr[mid+1]) {
				right=mid;
			}
			else {
				left=mid+1;
			}
		}
		return left;
	}

}
