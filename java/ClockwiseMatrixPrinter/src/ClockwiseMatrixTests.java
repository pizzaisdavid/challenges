import static org.junit.Assert.*;

import org.junit.Test;

public class ClockwiseMatrixTests {

	@Test
	public void test_size2() {
		char[][] matrix = {
			{'B', 'A'},
			{'C', 'D'}
		};
		
		String expected = "ABCD";
		String computed = Main.counterclockwiseRotate(matrix);
		assertEquals(expected, computed);
	}
	
	@Test
	public void test_size3() {
		char[][] matrix = {
			{'C', 'B', 'A'},
			{'D', 'I', 'H'},
			{'E', 'F', 'G'}
		};
		
		String expected = "ABCDEFGHI";
		String computed = Main.counterclockwiseRotate(matrix);
		assertEquals(expected, computed);
	}
	
	@Test
	public void test_size4() {
		char[][] matrix = {
			{'D', 'C', 'B', 'A'},
			{'E', 'N', 'M', 'L'},
			{'F', 'O', 'P', 'K'},
			{'G', 'H', 'I', 'J'}
		};
		
		String expected = "ABCDEFGHIJKLMNOP";
		String computed = Main.counterclockwiseRotate(matrix);
		assertEquals(expected, computed);
	}

}
