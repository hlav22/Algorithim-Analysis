import java.util.List;

/**
 * Searching Alg for any Structure
 * 
 * @author Hunter Lavender
 *
 */
public class DataSearcher {

	public static <E extends Comparable<E>> int sequentialSearch(int find, List<E> input) {

		// Sequential Sort Variables

		int position = -1;
		boolean found = false;
		int index = 0;
		while (!found && index < input.size()) {
			// Check the index
			if (input.get(index).equals(find)) {
				found = true;
				position = index;
			}
			index++;
		}
		return position;

	}

	public static <E extends Comparable<E>> int binarySearch(int find, List<E> input) {
		int low = 0;
		int high = input.size() - 1;
		return recursiveBinarySearch(find, low, high, input);
	}

	public static <E extends Comparable<E>> int recursiveBinarySearch(int find, int low, int high, List<E> input) {
		// Base Case Check
		if (low > high) {
			return -1;
		}
		// See if input is at the middle
		int mid = (low + high) / 2;
		if (input.get(mid).equals(find)) {
			return mid;
		}
		// Determine section to search
		if (input.get(mid).compareTo(input.get(find)) > 0) {
			return recursiveBinarySearch(find, mid + 1, high, input);
		} else
			return recursiveBinarySearch(find, low, mid - 1, input);
	}

}
