import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void test() {
		int grid[][] = {
			{1, 2, 3, 4, 5},
			{9, 7, 9, 7, 9},
			{7, 9, 7, 9, 7}
		};
		int snake = Main.findLongestSnakeLength(grid);
		assertEquals(5, snake);
	}

}
