
public class Main {
	public static void main(String args[]) {
		int grid[][] = {
			{1, 2, 3, 4, 5},
			{9, 7, 9, 7, 9},
			{7, 9, 7, 9, 7}
		};
		int length = findLongestSnakeLength(grid);
		System.out.println(length);
	}
	
	public static int findLongestSnakeLength(int grid[][]) {
		int longest = 0;
		for (int x = 0; x < grid.length; x++) {
			int column[] = grid[x];
			for (int y = 0; y < column.length; y++) {
				int current = findLongestSnakeLengthStartingAt(grid, x, y);
				if (current > longest) {
					longest = current;
				}
			}
		}
		return longest;
	}
	
	public static int findLongestSnakeLengthStartingAt(int grid[][], int x, int y) {
		return move(grid[x][y], grid, x, y);
	}
	
	public static int move(int previous, int grid[][], int x, int y) {
		final int VISITED_FLAG = -1;
		if (isValid(previous, grid, x, y)) {
			int current = grid[x][y];
			grid[x][y] = VISITED_FLAG;			
			int[] paths = {
				move(current, grid, x, y + 1),
				move(current, grid, x + 1, y),
				move(current, grid, x, y - 1),
				move(current, grid, x - 1, y)
			};
			return max(paths) + 1;
		} else {
			return 0;
		}

	}
	
	public static boolean isValid(int previous, int grid[][], int x, int y) {
		final int VISITED_FLAG = -1;
		final int ACCEPTABLE_DIFFERENCE = 1;
		try {
			int value = grid[x][y];
			if (value == VISITED_FLAG) {
				return false;
			} else {
				return Math.abs(value - previous) <= ACCEPTABLE_DIFFERENCE;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public static int max(int list[]) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < list.length; i++) {
			int value = list[i];
			if (value > max) {
				max = value;
			}
		}
		return max;
	}
}
