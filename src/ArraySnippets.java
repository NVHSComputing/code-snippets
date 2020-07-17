import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraySnippets {
	public static void main(String[] args) {
		// A bunch of code snippets for arrays that you could find useful, especially in competitive programming.
		int[] test = new int[]{1, 2, 4, 3, 5}; // initializes an array directly

		// Easy method to sort an array.
		Arrays.sort(test);

		// Arrays.toString pretty-fies an array. (Useful for debugging)
		// This code outputs
		// "[1, 2, 3, 4, 5]".
		System.out.println(Arrays.toString(test));

		String[] teststr = new String[]{"Foo", "Bar", "Baz"};
		ArrayList<Integer> ints = Arrays.stream(teststr).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
	}
}
