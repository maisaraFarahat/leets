package leets;

public class P2187MTtCT {
	public static long minimumTime(int[] time, int totalTrips) {
		 long low=Long.MAX_VALUE;
	        long high=0;
	        long min=Long.MAX_VALUE;
	        for(int it:time){
	            low=Math.min(low,it);
	            min=Math.min(min,it);
	        }
	        high=totalTrips*min;
	        while(low<high){
	            long mid=low+(high-low)/2;
	            if(blackbox(mid,totalTrips,time)){
	                high=mid;
	            }
	            else
	                low=mid+1;
	        }
	        return low;
	    }
	    public static boolean blackbox(long isvalidtime,int totalTrips,int[] time){
	        long trips=0;
	        for(int it:time){
	            trips+=isvalidtime/it;
	        }
	        if(trips>=totalTrips)
	            return true;
	        return false;
	    }

	public static void main(String[] args) {
		int[] time = { 2};
		int totalTrips = 1;
		long res = minimumTime(time, totalTrips);
		System.out.println(res);
	}
}
