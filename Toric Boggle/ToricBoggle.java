public class ToricBoggle {
	public static void main (String[] args) {
		int col = 3, row = 3;
		Letter[][]A = new Letter[col][row];
		String word = "XXX";
		int count = 0;
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				count+=check(A,i,j, word);
			}
		}
	}

	public class Letter {
		boolean visited;
		public Letter(char val) {
			visited = false; 
			char value = val;
		}
		public void setVisited(boolean set) {
			visited = set;
		}
	}

	public int increment(int index, int size) {
		return index==size-1 ? 0 : index++;
	}

	public int decrement(int index, int size) {
		return index==0 ? size-1 : index--;
	}

	public int check(Letter A[][], int i, int j, String word) {

	}
}