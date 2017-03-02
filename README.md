
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

```
Example BOO
B: 1
O: 2
3!/(1! * 2!) = 3
BOO
BOB
OOB
```


import java.util.HashMap;
Map<String, String> dictionary = new HashMap<String, String>();