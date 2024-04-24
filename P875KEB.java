package leets;

import java.util.Arrays;

public class P875KEB {
	    public static int minEatingSpeed(int[] piles, int h) {
	        int low=1;
	        int high=Integer.MIN_VALUE;
	        for(int i=0;i<piles.length;i++){
	            high=Math.max(high,piles[i]);
	        }
	        while(low<high){
	            int mid=low+(high-low)/2;
	            if(blackbox(mid,piles,h)){
	                high=mid;
	            }
	            else
	                low=mid+1;
	        }
	        return low;
	    }
	    public static boolean blackbox(int maxpiles,int[] piles,int h){
	        int hours=0;
	        for(int i:piles){
	            int time=i/maxpiles;
	            hours+=time;
	            if(i%maxpiles!=0) hours++;
	        }
	        if(hours<=h)
	            return true;
	        return false;
	    }

	public static void main(String[] args) {
		int[] piles = { 3, 6, 7, 11 };
		int h = 8;
		int res = minEatingSpeed(piles, h);
		System.out.println(res);
	}
}
