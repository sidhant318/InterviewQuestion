package General;

import java.util.Collections;
import java.util.PriorityQueue;

public class KSmall {

	public static void main(String[] args) {
		int[] arr= {3,5,6,2,1,7};  //123567
		System.out.println(kthSmallest(arr,0,5,3));
	}

	public static int kthSmallest(int[] arr, int l, int r, int k) 
    {
        PriorityQueue<Integer> queue=new PriorityQueue<>(k,Collections.reverseOrder());
        for(int i=l;i<=r;i++){
            queue.offer(arr[i]);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}



/*
 *    3
 * 1     2
 * 
 * */