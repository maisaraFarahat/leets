package leets;

public class P443StringCompression {
	public static int compress(char[] chars) {
		int c = 1;
		String res = "";
		for(int i = 0 ; i < chars.length-1 ; i++) {
			if(chars[i] != chars[i+1]) {
				res = res + chars[i] + ((c == 1)? "":c+"");
				c = 1;
			}
			else {
				c++;
			}
		}
		res = res + chars[chars.length-1] + ((c == 1)? "":c+"");
		
		char[] resArray = res.toCharArray();
		for ( int i = 0 ; i < resArray.length ; i++) {
			chars[i] = resArray[i];
		}
		return res.length();
	}
	public static void main(String[] args) {
		String s = "aabbccc";
		char[] input = s.toCharArray();
		int res = compress(input);
		System.out.println(res);
	}
	
}
