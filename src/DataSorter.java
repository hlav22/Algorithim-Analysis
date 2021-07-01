import java.util.List;

/**
 * Sorting Algorithms for any Data Structure
 * 
 * @author Hunter Lavender
 *
 */
public class DataSorter {

	// Bubble Sort Method
	public static <E extends Comparable<E>> void bubbleSort(List<E> input) {
		var size = input.size();
		for (int i = 0; i < size - 1; i++) {
			for (int z = 0; z < size - 1; z++) {
				if (input.get(z).compareTo(input.get(z + 1)) > 0) {
					E temp = input.get(z);
					input.set(z, input.get(z + 1));
					input.set(z + 1, temp);
				}
			}
		}

	}

	// Insertion Sort
	public static <E extends Comparable<E>> void insertionSort(List<E> input) {
		var size = input.size();
		for (int i = 0; i < size; i++) {
			E temp = input.get(i);
			int z = i - 1;
			while (z >= 0 && input.get(z).compareTo(temp) > 0) {
				input.set(z + 1, input.get(z));
				z = z - 1;
			}
			input.set(z + 1, temp);
		}

	}

	// Selection Sort
	public static <E extends Comparable<E>> void selectionSort(List<E> input) {
		var size = input.size();
		for (int i = 0; i < size - 1; i++) {
			var minElement = i;
			for (int z = i + 1; z < size; z++) {
				if (input.get(minElement).compareTo(input.get(z)) > 0) {
					minElement = z;
				}
			}
			E temp = input.get(i);
			input.set(i, input.get(minElement));
			input.set(minElement, temp);
		}
	}

	// Quick Sort
	public static <E extends Comparable<E>> void quickSort(List<E> input) {
		doQuicksort(input, 0, input.size() - 1);
	}

	// Swap for Quick Sort
	private static <E extends Comparable<E>> void swap(int i, int j, List<E> input) {
		E temp = input.get(i);
		input.set(i, input.get(j));
		input.set(j, temp);
	}

	// Partition For Quick Sort
	private static <E extends Comparable<E>> int partition(List<E> input, int start, int end) {
		var mid = (start + end) / 2;
		var endOfLeftList = start;
		swap(mid, start, input);
		var pivotValue = input.get(start);
		for (int i = start + 1; i <= end; i++) {
			if (input.get(i).compareTo(pivotValue) > 0) {
				endOfLeftList++;
				swap(i, endOfLeftList, input);
			}
		}
		swap(endOfLeftList, start, input);
		return endOfLeftList;

	}

	// doQuick Sort (Shown from Slides)

	private static <E extends Comparable<E>> void doQuicksort(List<E> input, int start, int end) {
		if (start < end) {
			int pivotPoint = partition(input, start, end);
			doQuicksort(input, start, pivotPoint - 1);
			doQuicksort(input, pivotPoint + 1, end);
		}
	}

}
