public class PalindromicSums {
	public static void main(String[] arg) {

		String ans = "121";

		do {
			int first = Integer.parseInt(ans);
			int second = Integer.parseInt(new StringBuilder(ans).reverse().toString());
			ans = (first+second) + "";
		}
		while(!(new StringBuilder(ans).reverse().toString().equals(ans)));
		System.out.println(ans);
	}
}
