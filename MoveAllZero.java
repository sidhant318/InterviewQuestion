package General;

public class MoveAllZero {

	public static void main(String[] args) {
		int[] arr={1, 2, 0, 4, 3, 0, 5, 0};
		moveForZero(arr);
		//moveForZero1(arr);
		print(arr);
	}


	private static void moveForZero(int[] arr) {
		int counter=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0){
				arr[counter++]=arr[i];
			}
		}
		while(counter<arr.length)
			arr[counter++]=0;
	}

	private static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
