/*Reverse digits of an integer*/

public class ReverseNumber {

	public int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int rem = x % 10;
			int prev_result = result;
			result = result * 10 + rem;
			// check integer overflow
			if (prev_result != result / 10) {
				return 0;
			}
			x = x / 10;
		}
		return result;
	}

	public static void main(String[] args) {
		ReverseNumber obj = new ReverseNumber();

		System.out.println(obj.reverse(-123));
	}
}
