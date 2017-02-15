
public class Guess {
	private String pegs;
	private int correctPositionAndColor;
	private int correctColor;
	
	public Guess(String pegs, int correctPositionAndColor, int correctColor) {
		this.pegs = pegs;
		this.correctPositionAndColor = correctPositionAndColor;
		this.correctColor = correctColor;
	}
	
	public boolean isNoPegsInCorrectPlace() {
	  return this.correctPositionAndColor == 0;
	}
	
	public String getPegs() {
	  return this.pegs;
	}

  public int pegCountInCorrectPositions() {
    return this.correctPositionAndColor;
  }
	
}
