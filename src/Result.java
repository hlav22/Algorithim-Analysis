import java.util.ArrayList;

/**
 * Results Class to Store Results from exp
 * 
 * @author Hunter Lavender
 *
 */
public class Result {

	private String alg;
	private String dS;
	private ArrayList<Long> times;

	// Constructor for Result
	public Result(String alg, String dS) {
		this.alg = alg;
		this.dS = dS;
		times = new ArrayList<>();
	}

	public void add(long t) {
		times.add(t);
	}

	public String toString() {
		double meanTime = 0;
		for (int i = 0; i < times.size(); i++) {
			meanTime += times.get(i);
		}
		meanTime = meanTime / times.size();
		return alg + "," + dS + "," + meanTime;

	}
}
