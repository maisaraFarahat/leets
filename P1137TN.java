package leets;

public class P1137TN {
	public int tribonacci(int n) {
		int[] ans = new int[n + 1];
		ans[0] = 0;
		if (n == 0)
			return ans[n];
		ans[1] = 1;
		if (n == 1)
			return ans[n];
		ans[2] = 1;
		if (n == 2)
			return ans[n];
		for (int i = 3; i <= n; i++) {
			ans[i] = ans[i - 1] + ans[i - 2] + ans[i - 3];
		}
		return ans[n];
	}
	public static void main(String[] args) {
		P1137TN s = new P1137TN();
		System.out.println(s.tribonacci(4));
	}
}
