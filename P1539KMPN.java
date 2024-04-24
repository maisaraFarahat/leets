package leets;

public class P1539KMPN {
	 public static int findKthPositive(int[] arr, int k) {
		 	boolean[] found = new boolean[arr[arr.length-1]+1 + k];
	        for(int x : arr) {
	        	found[x] = true; 
	        }
	        for(int i = 1; i < found.length; i++) {
	        	if(!found[i])
	        		k--;
	        	if(k == 0 )
	        		return i;
	        }
		 	return 0;
	    }
	 public static void main(String[] args) {
		int[] arr = {2,3,4,7,11};
		int k = 5;
		int res = findKthPositive(arr, k);
		System.out.println(res);
	}
}
