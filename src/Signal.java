/**
 * Signal Class For Data Loader
 * 
 * @author Hunter Lavender
 *
 */
public class Signal implements Comparable<Signal> {
	private double dM;
	private double sigma;
	private double time;
	private int sample;
	private int downFact;

	public Signal(double dM, double sigma, double time, int sample, int downFact) {
		this.dM = dM;
		this.sigma = sigma;
		this.time = time;
		this.sample = sample;
		this.downFact = downFact;
	}

	public Signal(String[] split) {
		this.dM = Double.parseDouble(split[0]);
		this.sigma = Double.parseDouble(split[1]);
		this.time = Double.parseDouble(split[2]);
		this.sample = Integer.parseInt(split[3]);
		this.downFact = Integer.parseInt(split[4]);

	}

	@Override
	public String toString() {
		return (dM + "," + sigma + "," + time + "," + sample + "," + downFact);
	}

	@Override
	// Comparison on the sigma value
	public int compareTo(Signal o) {
		if (this.sigma < o.sigma) {
			return 1;
		}
		if (this.sigma > o.sigma) {
			return -1;
		} else {
			return 0;
		}
	}
}
