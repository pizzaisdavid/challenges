import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import junit.framework.Assert;

public class Tests {
  
  @Test
  public void permutations_CAT() {
    String input = "CAT";
    String[] expected = new String[] {
      "CAT",
      "CTA",
      "ACT",
      "ATC",
      "TCA",
      "TAC"
    };
    assertArrayEquals(expected, Main.permutation(input).toArray());
  }
  
  @Test
  public void permutations_BOO() {
    String input = "BOO";
    String[] expected = new String[] {
      "BOO",
      "OBO",
      "OOB"
    };
    assertArrayEquals(expected, Main.permutation(input).toArray());
  }
}
