import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * CS Project 111. Algorithm Analysis
 * 
 * @author Hunter Lavender
 * 
 *         This class uses buffered reader and a constructor for Data Structures
 *         needed.
 */
public class DataLoader {

	private String inputFile;

	/**
	 * Constructor For DataLoader
	 */
	public DataLoader(String inputFile) {
		this.inputFile = inputFile;
	}

	public List<Signal> loadData() throws IOException {
		List<Signal> arrayList = new ArrayList<Signal>();
		SinglyLinkedList<Signal> singlyLinkedList = new SinglyLinkedList<Signal>();
		LinkedList<Signal> doublyLinkedList = new LinkedList<Signal>();
		File inFile = new File(inputFile);
		BufferedReader in = new BufferedReader(new FileReader(inFile));
		in.readLine(); // Reads and ignores the first line
		while (in.ready()) {
			String line = in.readLine();
			var split = line.split(" "); // Splits spaces at end of the line.
			Signal newSignal = new Signal(split);
			arrayList.add(newSignal); // Adds new signal to array
		}
		in.close(); // Closes Buffered Reader
		return (arrayList);

	}

	public List<Signal> loadDataDLL() throws IOException {
		LinkedList<Signal> doublyLinkedList = new LinkedList<Signal>();
		File inFile = new File(inputFile);
		BufferedReader in = new BufferedReader(new FileReader(inFile));
		in.readLine(); // Reads and ignores the first line
		while (in.ready()) {
			String line = in.readLine();
			var split = line.split(" "); // Splits spaces at end of the line.
			Signal newSignal = new Signal(split);
			doublyLinkedList.add(newSignal); // Adds new signal to doubly Linked List
		}
		in.close();
		return doublyLinkedList;
	}

	public List<Signal> loadDataLL() throws IOException {
		SinglyLinkedList<Signal> singlyLinkedList = new SinglyLinkedList<Signal>();
		File inFile = new File(inputFile);
		BufferedReader in = new BufferedReader(new FileReader(inFile));
		in.readLine(); // Reads and ignores the first line
		while (in.ready()) {
			String line = in.readLine();
			var split = line.split(" "); // Splits spaces at end of the line.
			Signal newSignal = new Signal(split);
			singlyLinkedList.add(newSignal); // Adds new signal to Singly Linked List
		}
		in.close();
		return singlyLinkedList;
	}
}
