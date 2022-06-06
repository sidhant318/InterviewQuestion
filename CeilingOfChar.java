package BinarySearch;

public class CeilingOfChar {

	public static void main(String[] args) {
		char[] arr= {'c','f','j'};
		System.out.println(findCeiling1(arr,'a'));
	}
	
	private static char findCeiling1(char[] arr, char k) {
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
		return arr[left];
	}

}
