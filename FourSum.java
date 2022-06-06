package General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		
		int[] arr=new int[]{-2,-1,-1,1,1,2,2};
		FourSum a=new FourSum();
		a.twoSum(arr);
		//List<List<Integer>> al=a.threeSum(arr);
		List<List<Integer>> al=a.fourSum(arr,6);
		for(List<Integer> la:al) {
			System.out.println(la);
		}

	}
	
	private void twoSum(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]==0) {
					System.out.println(arr[i]+" "+arr[j]);
				}
			}
		}
		System.out.println("--------------");
//		Arrays.sort(arr);
//		int i=0,j=arr.length-1;
//		while(i<=j) {
//			if(arr[i]+arr[j]==0) {
//				System.out.println(i+" "+j);
//				i++;
//				j--;
//			}
//			else if(arr[i]+arr[j]>0) {
//				j--;
//			}
//			else {
//				i++;
//			}
//		}
		
		HashSet<Integer> hs=new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			int tmp=0-arr[i];
			if(hs.contains(tmp)) {
				System.out.println(arr[i]+" "+tmp);//{-2,-1,-1,1,1,2,2}
				hs.add(arr[i]);
			}
			hs.add(arr[i]);
		}
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> mylists=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
        	if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
            	if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
            		int tar=target-nums[i]-nums[j];
                    int left=j+1;
                    int right=nums.length-1;
                    while(left<right){
                        int sum=nums[left]+nums[right];
                        if(sum>tar){
                            right--;
                        }
                        else if(sum<tar){
                            left++;
                        }
                        else{
                            List<Integer> l=new ArrayList<>();
                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(nums[left]);
                            l.add(nums[right]);
                            mylists.add(l);
                            left++;
                            right--;
                            while(left<right && nums[left]==nums[left-1]){
                                left++;
                            }
                            while(left<right && nums[right]==nums[right+1]){
                                right--;
                            }
                        }
                    }
            }
        }
        return mylists;
    }

	public List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> mylists=new ArrayList<>();
		Arrays.sort(nums);//[-4,-1,-1,0,1,2]
	    for(int i=0;i<nums.length-2;i++){
	    	if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
	    		int left=i+1;
		        int right=nums.length-1;
		        int total=0-nums[i];
		        while(left<right){
		           if(nums[left]+nums[right]==total){
		               List<Integer> l=new ArrayList<>();
		                l.add(nums[i]);
		                l.add(nums[left]);
		                l.add(nums[right]);
		                mylists.add(l);
		                left++;
		                right--;
		           } 
		           else if(nums[left]+nums[right]>total) {
		        	   right--;
		           }
		           else {
		        	   left++;
		           }
		        }
	    	}
	        
	    }
	    return mylists;
	}
	
	
	
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> mylists=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            HashMap<Integer,Integer> hm=new HashMap<>();
            int total=0-nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(hm.containsKey(total-nums[j])){
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[hm.get(total-nums[j])]);
                    l.add(nums[j]);
                    mylists.add(l);
                }
                else{
                    hm.put(nums[j],j);
                }
            }
        }
        return mylists;
    }

}
