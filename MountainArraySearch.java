package BinarySearch;

public class MountainArraySearch {

	public static void main(String[] args) {
		int arr[]= {2,4,6,9,8,7,5,1};
		System.out.println(findPeek(arr));

	}

	private static int findPeek(int arr[]) {
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
			return arr[left];
	}

}
