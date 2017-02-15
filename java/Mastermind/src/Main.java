import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  private static Solution[] solutions;
  
	public static void main(String args[]) {
		
		Guess[] guesses = {
			new Guess("RRRR", 3, 1),
			new Guess("GBBB", 0, 1),
			new Guess("BGBB", 0, 1), 
			new Guess("BBBG", 0, 1)
		};
		
		Solution[] solutions = mastermind(guesses);
		
	}
	
	public static Solution[] mastermind(Guess[] guesses) {
	  solutions = setupSolutions();
	  for (int i = 0; i < guesses.length; i++) {
	    Guess guess = guesses[i];
	    evaluate(guess);
	  }
    System.out.println(solutions[0]);
    return verify(solutions);
	}
	
	public static Solution[] setupSolutions() {
	  return new Solution[] {
	      new Solution(),
	      new Solution(),
	      new Solution(),
	      new Solution()
	      
	  };
	}
	
	public static void evaluate(Guess guess) {
	  if (guess.isNoPegsInCorrectPlace()) {
	    for (int i = 0; i < solutions.length; i++) {
	      String pegs = guess.getPegs();
	      solutions[i].remove(pegs.charAt(0), pegs.charAt(1), pegs.charAt(2), pegs.charAt(3));
	    }
	  }
	  
	}
	
	public static Solution[] verify(Solution[] solutions) {
	  List<Solution> completeSolutions = new ArrayList<Solution>();
	  for (int i = 0; i < solutions.length; i++) {
	    Solution solution = solutions[i];
	    if (solution.isComplete()) {
	      completeSolutions.add(solution);
	    }
	  }
	  Solution[] complete = new Solution[completeSolutions.size()];
	  for (int i = 0; i < completeSolutions.size(); i++) {
	    complete[i] = completeSolutions.get(0);
	  }
	  return complete;
	}
}
