package BinarySearch;

public class InfiniteArray {

	public static void main(String[] args) {
		int arr[]= {5,6,7,8,9,11,12,14,16,17,18,20,22,33,44,55,66,77,88};
		System.out.println(findValue(arr,21));

	}

	private static int findValue(int[] arr, int k) {
		int start=0;
		int end=2;
		while(k>=arr[end]) {
			start=end;
			end=2*end;
		}
		return findValue(arr,k,start,end);
	}

	private static int findValue(int[] arr, int k, int left, int right) {
			while(left<=right) {
				int mid=(left+right)/2;
				if(arr[mid]==k)
					return arr[mid];
				if(arr[mid]<k) {
					left=mid+1;
				}
				else {
					right=mid-1;
				}
			}
			
		return -1;
	}

}
