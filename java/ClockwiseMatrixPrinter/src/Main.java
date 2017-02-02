
public class Main {
	
	public static void main(String args[]) {
		char [][] matrix = {
	        {'D', 'C', 'B', 'A'},
	        {'E', 'N', 'M', 'L'},
	        {'F', 'O', 'P', 'K'},
	        {'G', 'H', 'I', 'J'}
		};
	}
	
	public static String counterclockwiseRotate(char[][] matrix) {
		/* TODO 
		 * while (matrix.length())
		 * rotate around he outer most ring.
		 * remove the outer most ring, return
		 * */
		String found = "";
		while (matrix.length != 0) {
			found = appendOuterRing(matrix, found);
			matrix = removeOuterRing(matrix);
		}
		return found;
	}
	
	public static String appendOuterRing(char[][] matrix, String found) {
		int startingIndex = matrix.length - 1;
		if (startingIndex == 0) {
			found += matrix[0][0];
		} else {
			
			// top row
			// right to left
			for (int i = startingIndex; i >= 0; i--) {
				char character = matrix[0][i];
				found += character;
			}
			
			// first column
			// top to bottom (excluding top-most and bottom-most)
			for (int i = 1; i <= startingIndex - 1; i++) {
				found += matrix[i][0];
			}
			
			// bottom row
			// left to right 
			for (int i = 0; i < matrix.length; i++) {
				char character = matrix[startingIndex][i];
				found += character;
			}
			
			// last column
			// bottom to top (excluding top-most and bottom-most)
			for (int i = startingIndex - 1; i > 0; i--) {
				found += matrix[i][startingIndex];
			}
		}
		return found;
	}
	
	public static char[][] removeOuterRing(char[][] matrix) {
		if (matrix.length == 1) {
			return new char[0][0];
		}
		int length = matrix.length;
		int newLength = length - 2;
		char[][] newMatrix = new char[newLength][newLength];
		for (int y = 1; y < matrix.length - 1; y++) {
			for (int x = 1; x < matrix.length - 1; x++) {
				newMatrix[y - 1][x - 1] = matrix[y][x];
			}
		}
		return newMatrix;
	}
}
