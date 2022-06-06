package BinarySearch;

public class StartEndPosition {

	public static void main(String[] args) {
		int arr[]= {5,6,7,7,7,8,9};
		int ans[]=findStartEnd(arr,7);
		System.out.println("Start Point is "+ans[0]+" and End Point is "+ans[1]);
	}

	private static int[] findStartEnd(int[] arr,int k) {
		int tmp[]= {-1,-1};
		//find start Index 
		tmp[0]=findPosition(arr,k,true);
		//find end Index 
		tmp[1]=findPosition(arr,k,false);
		return tmp;
	}

	private static int findPosition(int[] arr, int k, boolean b) {
		int start=0;
		int end=arr.length-1;
		int tmp=-1;
		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]>k) {
				end=mid-1;
			}
			else if(arr[mid]<k) {
				start=mid+1;
			}
			else {
				tmp=mid;
				if(b) {
					end=mid-1;
				}
				else {
					start=mid+1;
				}
			}
		}
		return tmp;
	}

}
