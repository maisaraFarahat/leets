package leets;

public class P2444CSWFB {
	public static long countSubarrays(int[] nums, int minK, int maxK) {
		long res = 0;
		int lowerBound = -1;
		int lastMin = -1;
		int lastMax = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= maxK && nums[i] >= minK) {
				lastMax = (nums[i] == maxK) ? i : lastMax;
				lastMin = (nums[i] == minK) ? i : lastMin;
				res += Math.max(0, Math.min(lastMax, lastMin) - lowerBound);
			} else {
				lastMax = -1;
				lastMin = -1;
				lowerBound = i;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 35054, 398719, 945315, 945315, 820417, 945315, 35054, 945315, 171832, 945315, 35054, 109750,
				790964, 441974, 552913 };
		int min = 35054;
		int max = 945315;
		long res = countSubarrays(nums, min, max);
		System.out.println(res);
	}
}
