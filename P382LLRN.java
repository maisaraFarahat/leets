package leets;

import java.util.Random;


class Solution {
	ListNode sol;
	int size;

	public Solution(ListNode head) {
		sol = head;
		int s = 0;
		if (head != null)
			s++;

		ListNode curr = head.next;
		while (curr != null) {
			s++;
			curr = curr.next;
		}
		size = s;
	}

	public int getRandom() {
		Random rand = new Random();
		int r = rand.nextInt(size);
		if (r == 0)
			return sol.val;

		ListNode curr = sol.next;
		while (r != 1) {
			r--;
			curr = curr.next;
		}

		return curr.val;

	}
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(head); int param_1 = obj.getRandom();
 */
public class P382LLRN {
	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		Solution obj = new Solution(head);
		int param_1 = obj.getRandom();
		System.out.println(param_1);
	}
}
