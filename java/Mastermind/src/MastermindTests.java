import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MastermindTests {

  @Test
  public void test_noSolutions() {
    Guess[] guesses = {
      new Guess("RRRR", 0, 1)
    };  
    Solution[] expected = {};
    Solution[] computed = Main.mastermind(guesses);
    assertArrayEquals(expected, computed);
  }
  
  @Test
  public void test_threeSolutions() {
    Guess[] guesses = {
      new Guess("RRRR", 3, 1),
      new Guess("GBBB", 0, 1),
      new Guess("BGBB", 0, 1), 
      new Guess("BBBG", 0, 1)
    };
    Solution[] expected = {new Solution("R", "R", "G", "R")};
    Solution[] computed = Main.mastermind(guesses);
    assertArrayEquals(expected, computed);
  }
}
