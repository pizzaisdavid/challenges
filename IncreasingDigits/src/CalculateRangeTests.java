import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateRangeTests {

	@Test
	public void test_smallestPossible() {
		int numberOfDigits = 3;
		int smallest = main.calculateSmallestPossiblePassword(numberOfDigits);
		int expected = 100;
		assertEquals(expected, smallest);
	}
	
	@Test
	public void test_largestPossible() {
		int numberOfDigits = 3;
		int largest = main.calculateLargestPossiblePassword(numberOfDigits);
		int expected = 999;
		assertEquals(expected, largest);
	}
	
	@Test
	public void test_isTrue() {
		int number = 12345;
		assertTrue(main.isIncreasingDigits(number));
	}

	@Test
	public void test_isFalse() {
		int number = 54321;
		assertFalse(main.isIncreasingDigits(number));
	}
}
