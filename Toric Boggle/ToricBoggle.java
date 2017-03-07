public class ToricBoggle {
	public static int col, row;
	public static void main (String[] args) {
		String word = "BOO";
		setParams(6,3);
		Letter[][] A = {
			{ new Letter('B'), new Letter('O'), new Letter('O'), new Letter('B'), new Letter('O'), new Letter('O') },
			{ new Letter('O'), new Letter('B'), new Letter('O'), new Letter('O'), new Letter('B'), new Letter('O') },
			{ new Letter('O'), new Letter('O'), new Letter('B'), new Letter('O'), new Letter('O'), new Letter('B') },
		};
		int count = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				count+=check(A,i,j,word);
			}
		}
		System.out.println(count);
	}
	public static void setParams(int column, int roww) {
		col = column;
		row = roww;
	}
	public static int inc(int index, int size) {
		return index==size-1 ? 0 : ++index;
	}

	public static int dec(int index, int size) {
		return index==0 ? size-1 : --index;
	}

	public static int check(Letter A[][], int i, int j, String word) {
		int count = 0;
		if(A[i][j].visited()) { //If I'm already in the path, do not disturb
			return 0;
		}
		else A[i][j].visit(true);
		if(word.charAt(0)==A[i][j].value()) {
			if(word.length()==1){
				A[i][j].visit(false);
				return 1;
			}
			count+=check(A,inc(i,row),j,word.substring(1));//Right
			count+=check(A,dec(i,row),j,word.substring(1));//Left
			count+=check(A,i,inc(j,col),word.substring(1));//Down
			count+=check(A,i,dec(j,col),word.substring(1));//Up
			count+=check(A,dec(i,row),dec(j,col),word.substring(1));//Left-Up
			count+=check(A,inc(i,row),dec(j,col),word.substring(1));//Right-Up
			count+=check(A,dec(i,row),inc(j,col),word.substring(1));//Left-Down
			count+=check(A,inc(i,row),inc(j,col),word.substring(1));//Right-Down
		}
		A[i][j].visit(false);
		return count;
	}
}
class Letter {
	boolean visited;
	char value;
	static int length;
	static int height;
	public static void setParams(int len, int ht) {
		length = len;
		height = ht;
	}
	public Letter(char val) {
		visited = false; 
		value = val;
	}
	public void visit(boolean set) {
		visited = set;
	}
	public char value() {
		return value;
	}
	public boolean visited() {
		return visited;
	}
}