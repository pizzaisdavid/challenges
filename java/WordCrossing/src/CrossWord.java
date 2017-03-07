import java.util.ArrayList;
import java.util.List;

public class CrossWord {
  private static final char VALID_PLACE_FOR_A_LETTER = '*';
  private static final char INVALID_PLACE = ' ';
  private char[][] board;

  public CrossWord(char[][] board) {
    this.board = board;
  }

  public void solve(List<String> words) {
    board = solve(board, words);
  }

  private char[][] solve(char[][] board, List<String> words) {
    if (words.isEmpty()) {
      System.out.println("DONE");
      System.out.println(this);
    }
    char[][] hypotheticalBoard = copy(board);    
    WordSlot slot = findNextOpening(hypotheticalBoard);
    System.out.println("LINE=" + slot);
    
    for (String word : words) {
      if (slot.fits(word)) {
        
        fill(hypotheticalBoard, slot, word);
        List<String> hypotheticalWords = copy(words);
        hypotheticalWords.remove(word);
        solve(hypotheticalBoard, hypotheticalWords);
      }
    }
    
    return hypotheticalBoard;
  }

  private void fill(char[][] board, WordSlot slot, String word) {
    // TODO stuff
    
    if (slot.getDirection() == Direction.VERTICAL) {
      fillVertical(board, slot, word);
    } else {
      fillHorizontal(board, slot, word);
    }
    
  }

  private void fillVertical(char[][] board, WordSlot slot, String word) {
    int x = slot.getI();
    int y = slot.getJ();
    for (int i = 0; i < word.length(); i++) {
      board[x + i][y] = word.charAt(i);
    }
  }
  
  private void fillHorizontal(char[][] board2, WordSlot slot, String word) {
    int x = slot.getI();
    int y = slot.getJ();
    for (int i = 0; i < word.length(); i++) {
      board[x][y + i] = word.charAt(i);
    }
  }

  private WordSlot findNextOpening(char[][] hypotheticalBoard) {
    // once we encounter an asterisk
    for (int i = 0; i < hypotheticalBoard.length; i++) {
      char[] row = hypotheticalBoard[i];
      for (int j = 0; j < row.length; j++) {
        char value = hypotheticalBoard[i][j];
        if (value == VALID_PLACE_FOR_A_LETTER) {
          return isolateOpening(hypotheticalBoard, i, j);
        }
      }
    }
    return WordSlot.NULL;
  }

  private WordSlot isolateOpening(char[][] hypotheticalBoard, int i, int j) {
    // go both ways
    //    up and down
    //    left and right
    // until a space is hit or the end of the board
    WordSlot vertical = isolateVertical(hypotheticalBoard, i, j);
    WordSlot horizontal = isolateHorizontal(hypotheticalBoard, i, j);
    if (vertical.isValid()) {
      return horizontal;
    } else {
      return vertical;
    }
  }

  private WordSlot isolateVertical(char[][] hypotheticalBoard, int i, int j) {
    String vertical = "";
    vertical += hypotheticalBoard[i][j];
    int height = i;    
    for (int up = i - 1; up > 0; up--) {
      char character = get(hypotheticalBoard, up, j);
      height--;
      if (character == '\0' || character == INVALID_PLACE) {
        break;
      } else {
        vertical = character + vertical;
      }
    }
    
    for (int down = i + 1; down < hypotheticalBoard.length; down++) {
      char character = get(hypotheticalBoard, down, j);
      if (character == '\0' || character == INVALID_PLACE) {
        break;
      } else {
        vertical = vertical + character;
      }
    }
    return new WordSlot(vertical, height, j, Direction.VERTICAL);
  }
  
  private WordSlot isolateHorizontal(char[][] hypotheticalBoard, int i, int j) {
    String horizontal = "";
    horizontal += hypotheticalBoard[i][j];
    int width = j;
    for (int left = j - 1; left > 0; left--) {
      char character = get(hypotheticalBoard, i, left);
      width--;
      if (character == '\0' || character == INVALID_PLACE) {
        break;
      } else {
        horizontal = character + horizontal;
      }
    }
    
    for (int right = j + 1; right < hypotheticalBoard.length; right++) {
      char character = get(hypotheticalBoard, i, right);
      if (character == '\0' || character == INVALID_PLACE) {
        break;
      } else {
        horizontal = horizontal + character;
      }
    }
    return new WordSlot(horizontal, i, width, Direction.HORIZONTAL);
  }


  private char get(char[][] b, int i, int j) {
    try {
      return b[i][j];
    } catch (Exception e) {
      return '\0';
    }
  }

  private static char[][] copy(char[][] board) {
    char[][] paste = new char[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      char[] row = board[i];
      for (int j = 0; j < row.length; j++) {
        paste[i][j] = row[j];
      }
    }
    return paste;
  }
  
  private List<String> copy(List<String> words) {
    List<String> paste = new ArrayList<String>();
    for (String word : words) {
      paste.add(word);
    }
    return paste;
  }
  
  public String toString() {
    String text = "";
    for (int i = 0; i < board.length; i++) {
      char[] row = board[i];
      for (int j = 0; j < row.length; j++) {
        text += board[i][j];
      }
      text += "\n";
    }
    return text;
  }
  
}
