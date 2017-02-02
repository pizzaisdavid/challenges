public class main {
   public static void main(String[] args) {
	   int numberOfDigits = 3;
	   int smallest = calculateSmallestPossiblePassword(numberOfDigits);
	   int largest = calculateLargestPossiblePassword(numberOfDigits);
	   for (int i = smallest; i < largest; i++) {
		   if (isIncreasingDigits(i)) {
			   System.out.println(i);
		   }
	   }
   }
   
   public static int calculateSmallestPossiblePassword(int numberOfDigits) {
	   return (int) Math.pow(10, numberOfDigits - 1);
   }
   
   public static int calculateLargestPossiblePassword(int numberOfDigits) {
	   return (int) Math.pow(10, numberOfDigits) - 1;
   }
   
   public static boolean isIncreasingDigits(int number) {
	   int previous = 0;
	   String text = number + "";
	   for (int i = 0; i < text.length(); i++) {
		   int digit = convert(text.charAt(i));
		   if (previous < digit) {
			   previous = digit;
		   } else {
			   return false;
		   }
	   }
	   return true;
   }

	private static int convert(char character) {
		return Character.getNumericValue(character);
	}
}