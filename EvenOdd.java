package General;

public class EvenOdd {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 2, 4, 7, 6, 9, 10 };
        int n = arr.length;

        // Function call
        arrayEvenAndOdd(arr, n);
        print(arr);
	}

	private static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

	private static void arrayEvenAndOdd(int[] arr, int n) {
		int pointer=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {
				int val=arr[pointer];
				arr[pointer]=arr[i];
				arr[i]=val;
				pointer++;
			}
		}
		
	}

}
