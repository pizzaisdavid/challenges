
public class Solution {
  private PotentialPeg[] pegs;
  
  public Solution() {
    this.pegs = new PotentialPeg[] {
      new PotentialPeg(),
      new PotentialPeg(),
      new PotentialPeg(),
      new PotentialPeg()
    };
  }
    
  public Solution(String first, String second, String third, String fourth) {
    this.pegs = new PotentialPeg[] {
        new PotentialPeg(first),
        new PotentialPeg(second),
        new PotentialPeg(third),
        new PotentialPeg(fourth)
    };
  }
  
  public void remove(char first, char second, char third, char fourth) {
    pegs[0].remove(first);
    pegs[1].remove(second);
    pegs[2].remove(third);
    pegs[3].remove(fourth);    
  }
  
  public boolean isComplete() {
    for(int i = 0; i < pegs.length; i++) {
      if (pegs[i].count() != 1) {
        return false;
      }
    }
    return true;
  }
  
  public String toString() {
    return pegs[0] + ", " + pegs[1] + ", " + pegs[2] + ", " + pegs[3];
    
  }
}
