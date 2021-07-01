import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Driver {
	public static final int TEST = 10;

	/**
	 * Main Method "Driver"
	 * 
	 * @param args
	 * @author Hunter Lavender
	 * @throws IOException
	 */

	// Important Project Link to read:
	// https://www.tutorialspoint.com/java/lang/system_currenttimemillis.htm

	public static void main(String[] args) throws IOException {
		DataLoader dl = new DataLoader("palfa.txt");
		BufferedWriter out = new BufferedWriter(new FileWriter(new File("expResults.csv")));
		out.write("Algorithm, Data Structure, Time(ms)" + "\n");
		// Array List Bubble Sort Experiment
		Result bubbleAL = new Result("BubbleSort", "ArrayList");
		for (int i = 0; i < TEST; i++) {
			ArrayList<Signal> arrayL = new ArrayList<>();
			arrayL.addAll(dl.loadData());
			long startTime = System.currentTimeMillis();
			DataSorter.bubbleSort(arrayL);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			bubbleAL.add(elapsed);
		}
		out.write(bubbleAL + "\n");
		// Array List Insertion Sort Experiment
		Result insertionAL = new Result("InsertionSort", "ArrayList");
		for (int i = 0; i < TEST; i++) {
			ArrayList<Signal> arrayL = new ArrayList<>();
			arrayL.addAll(dl.loadData());
			long startTime = System.currentTimeMillis();
			DataSorter.insertionSort(arrayL);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			insertionAL.add(elapsed);
		}
		out.write(insertionAL + "\n");
		// Array List Selection Sort Experiment
		Result selectionAL = new Result("SelectionSort", "ArrayList");
		for (int i = 0; i < TEST; i++) {
			ArrayList<Signal> arrayL = new ArrayList<>();
			arrayL.addAll(dl.loadData());
			long startTime = System.currentTimeMillis();
			DataSorter.selectionSort(arrayL);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			selectionAL.add(elapsed);
		}
		out.write(selectionAL + "\n");
		// Array List Quick Sort Experiment
		Result quickAL = new Result("QuickSort", "ArrayList");
		for (int i = 0; i < TEST; i++) {
			ArrayList<Signal> arrayL = new ArrayList<>();
			arrayL.addAll(dl.loadData());
			long startTime = System.currentTimeMillis();
			DataSorter.quickSort(arrayL);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			quickAL.add(elapsed);
		}
		out.write(quickAL + "\n");
		// Tests below are for sorting LinkedList
		// Bubble Sort Linked List Test

		Result bubbleLL = new Result("BubbleSort", "LinkedList");
		for (int i = 0; i < TEST; i++) {
			SinglyLinkedList<Signal> singleLink = new SinglyLinkedList<>();
			singleLink.addAll(dl.loadDataLL());
			long startTime = System.currentTimeMillis();
			DataSorter.bubbleSort(singleLink);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			bubbleLL.add(elapsed);
		}
		out.write(bubbleLL + "\n");
		// Selection Sort Linked List Test

		Result selectionLL = new Result("SelectionSort", "LinkedList");
		for (int i = 0; i < TEST; i++) {
			SinglyLinkedList<Signal> singleLink = new SinglyLinkedList<>();
			singleLink.addAll(dl.loadDataLL());
			long startTime = System.currentTimeMillis();
			DataSorter.selectionSort(singleLink);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			selectionLL.add(elapsed);
		}
		out.write(selectionLL + "\n");
		// Quick Sort Linked List Test

		Result quickLL = new Result("QuickSort", "LinkedList");
		for (int i = 0; i < TEST; i++) {
			SinglyLinkedList<Signal> singleLink = new SinglyLinkedList<>();
			singleLink.addAll(dl.loadDataLL());
			long startTime = System.currentTimeMillis();
			DataSorter.quickSort(singleLink);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			quickLL.add(elapsed);
		}
		out.write(quickLL + "\n");
		// Test Below are for Sorting DoublyLinkedList (Implements Java LinkedList)
		// Bubble Sort Double Linked List
		Result bubbleDL = new Result("BubbleSort", "DoublyLinkedList ");
		for (int i = 0; i < TEST; i++) {
			LinkedList<Signal> doublyLink = new LinkedList<>();
			doublyLink.addAll(dl.loadDataDLL());
			long startTime = System.currentTimeMillis();
			DataSorter.bubbleSort(doublyLink);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			bubbleDL.add(elapsed);
		}
		out.write(bubbleDL + "\n");
		// Selection Sort Doubly Linked List
		Result selectionDL = new Result("SelectionSort", "DoublyLinkedList");
		for (int i = 0; i < TEST; i++) {
			LinkedList<Signal> doublyLink = new LinkedList<>();
			doublyLink.addAll(dl.loadDataDLL());
			long startTime = System.currentTimeMillis();
			DataSorter.selectionSort(doublyLink);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			selectionDL.add(elapsed);
		}
		out.write(selectionDL + "\n");
		// Quick Sort Doubly Linked List
		Result quickDL = new Result("QuickSort", "DoublyLinkedList");
		for (int i = 0; i < TEST; i++) {
			LinkedList<Signal> doublyLink = new LinkedList<>();
			doublyLink.addAll(dl.loadDataDLL());
			long startTime = System.currentTimeMillis();
			DataSorter.quickSort(doublyLink);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			quickDL.add(elapsed);
		}
		out.write(quickDL + "\n");
		// Sorting Test
		Result recurBinarySearch = new Result("Recursive Binary Search", "ArrayList");
		Random r = new Random();
		for (int i = 0; i < TEST; i++) {
			ArrayList<Signal> arrayL = new ArrayList<>();
			arrayL.addAll(dl.loadData());
			long startTime = System.currentTimeMillis();
			DataSorter.quickSort(arrayL);
			DataSearcher.recursiveBinarySearch(r.nextInt(arrayL.size()), i, arrayL.size(), arrayL);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			recurBinarySearch.add(elapsed);
		}
		out.write(recurBinarySearch + "\n");
		Result sequentialSearch = new Result("Sequential Search", "ArrayList");
		for (int i = 0; i < TEST; i++) {
			ArrayList<Signal> arrayL = new ArrayList<>();
			arrayL.addAll(dl.loadData());
			long startTime = System.currentTimeMillis();
			DataSearcher.sequentialSearch(r.nextInt(arrayL.size()), arrayL);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			sequentialSearch.add(elapsed);
		}
		out.write(sequentialSearch + "\n");
		Result binarySearch = new Result("Binary Search", "ArrayList");
		for (int i = 0; i < TEST; i++) {
			ArrayList<Signal> arrayL = new ArrayList<>();
			arrayL.addAll(dl.loadData());
			long startTime = System.currentTimeMillis();
			DataSorter.quickSort(arrayL);
			DataSearcher.binarySearch(r.nextInt(arrayL.size()), arrayL);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			binarySearch.add(elapsed);
		}
		out.write(binarySearch + "\n");
		Result recurBinarySearchSLL = new Result("Recursive Binary Search", "Singly Linked List");
		for (int i = 0; i < TEST; i++) {
			SinglyLinkedList<Signal> singleLink = new SinglyLinkedList<>();
			singleLink.addAll(dl.loadData());
			long startTime = System.currentTimeMillis();
			DataSorter.quickSort(singleLink);
			DataSearcher.recursiveBinarySearch(r.nextInt(singleLink.size()), i, singleLink.size(), singleLink);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			recurBinarySearchSLL.add(elapsed);
		}
		out.write(recurBinarySearchSLL + "\n");
		Result sequentialSearchSLL = new Result("Sequential Search", "Singly Linked List");
		for (int i = 0; i < TEST; i++) {
			SinglyLinkedList<Signal> singleLink = new SinglyLinkedList<>();
			singleLink.addAll(dl.loadData());
			long startTime = System.currentTimeMillis();
			DataSearcher.sequentialSearch(r.nextInt(singleLink.size()), singleLink);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			sequentialSearchSLL.add(elapsed);
		}
		out.write(sequentialSearchSLL + "\n");

		Result binarySearchSLL = new Result("Binary Search", "Singly Linked List");
		for (int i = 0; i < TEST; i++) {
			SinglyLinkedList<Signal> singleLink = new SinglyLinkedList<>();
			singleLink.addAll(dl.loadData());
			long startTime = System.currentTimeMillis();
			DataSorter.quickSort(singleLink);
			DataSearcher.binarySearch(r.nextInt(singleLink.size()), singleLink);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			binarySearchSLL.add(elapsed);
		}
		out.write(binarySearchSLL + "\n");
		Result recurBinarySearchDLL = new Result("Recursive Binary Search", "Doubly Linked List");
		for (int i = 0; i < TEST; i++) {
			LinkedList<Signal> doublyLink = new LinkedList<>();
			doublyLink.addAll(dl.loadData());
			long startTime = System.currentTimeMillis();
			DataSorter.quickSort(doublyLink);
			DataSearcher.recursiveBinarySearch(r.nextInt(doublyLink.size()), i, doublyLink.size(), doublyLink);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			recurBinarySearchDLL.add(elapsed);
		}
		out.write(recurBinarySearchDLL + "\n");

		Result sequentialSearchDLL = new Result("Sequential Search", "Doubly Linked List");
		for (int i = 0; i < TEST; i++) {
			LinkedList<Signal> doublyLink = new LinkedList<>();
			doublyLink.addAll(dl.loadData());
			long startTime = System.currentTimeMillis();
			DataSearcher.sequentialSearch(r.nextInt(doublyLink.size()), doublyLink);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			sequentialSearchDLL.add(elapsed);
		}
		out.write(sequentialSearchDLL + "\n");
		Result binarySearchDLL = new Result("Binary Search", "Doubly Linked List");
		for (int i = 0; i < TEST; i++) {
			LinkedList<Signal> doublyLink = new LinkedList<>();
			doublyLink.addAll(dl.loadData());
			long startTime = System.currentTimeMillis();
			DataSorter.quickSort(doublyLink);
			DataSearcher.binarySearch(r.nextInt(doublyLink.size()), doublyLink);
			long stopTime = System.currentTimeMillis();
			long elapsed = stopTime - startTime;
			binarySearchDLL.add(elapsed);
		}
		out.write(binarySearchDLL + "\n");
		out.close();
//		LinkedList<Signal> doublyLink = new LinkedList<>();
//		for (Signal s : arrayL) {
//		 System.out.println(s);
//		 }

	}

}
