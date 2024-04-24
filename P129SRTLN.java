package leets;

import java.util.ArrayList;

public class P129SRTLN {
	public static int sumNumbers(TreeNode root) {
		ArrayList<String> res = new ArrayList<>();
		String acc = "";
		helper(root, res, acc);
		int sum = 0;
		for(String s : res) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}

	public static void helper(TreeNode root, ArrayList<String> res, String accumulator) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			accumulator = accumulator + root.val;
			res.add(accumulator);
			return;
		}
		accumulator = accumulator + root.val;
		if(root.left!= null)
			helper(root.left,res,accumulator);
		if(root.right!= null)
			helper(root.right,res,accumulator);
		
	}
}
