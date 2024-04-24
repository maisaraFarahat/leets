package leets;

public class P28Occurence {
	public static int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	public static void main(String[] args) {
		String s1 = "sadbutsad";
		String s2 = "sad";
		System.out.println(strStr(s1, s2));

	}
}
