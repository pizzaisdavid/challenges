
# Java vs C++


Java is better for two dimensional arrays, because when initializing or creating a function definition you don't have to specify any array lengths.

```Java
// initialization
char [][] matrix = {
  {'D', 'C', 'B', 'A'},
  {'E', 'N', 'M', 'L'},
  {'F', 'O', 'P', 'K'},
  {'G', 'H', 'I', 'J'}
};

// usage
char value = matrix[rowIndex][columnIndex];

// function definition
public static String counterclockwiseRotate(char[][] matrix) {
  ...
}
```

## Combinations and Permutations

Combinations order doesn't matter.

Permutations order matters (A, B, C is different than C, B, A)

n: total number of elements

r: number of objects picking

### Combinations
<sub>n</sub>C<sub>r</sub> = n! / r! (n - r)!

### Permutations
<sub>n</sub>P<sub>r</sub> = n! / (n - r)!

##### Distinguishable Permutations

n! / (k<sub>1</sub>! k<sub>2</sub>! ... k<sub>x</sub>!)

n: total number of elements

k: the count of that element

```Python
Example BOO
B: 1
O: 2
3!/(1! * 2!) = 3
BOO
BOB
OOB

def distinguishable_permutations(text):
    # returns an array of tuples
    return sorted({p for p in permutations(text, len(text))})
```

###Hashmaps
```Java 
  import java.util.HashMap;
  
  Map<String, Integer> dictionary = new HashMap<String, Integer>();
  String key = "string";
  int value = 0;
  dictionary.put(key, value);
  
  for (Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey();
    int value = entry.getValue();
      ...
  }
  
```

###Helper functions
```
  public static boolean isPalindrome(String s) {
    return new StringBuilder(s).reverse().toString().equals(s);
  } 
  
  public static int stringToInt(String s) {
    return Integer.parseInt(s);
  }
  
  public static double format(double d) {
    DecimalFormat formatter = new DecimalFormat("#.00");
    return Double.parseDouble(formatter.format(d));
  }
```
