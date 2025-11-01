/**
 * 
 */

public class Company {
	private String name;
	private int cik;
	private Metrics[] metrics;
	private Chart[] charts;

	// Constructor
	public Company(String name, int cik) {
		this.name = name;
		this.cik = cik;
		this.metrics = new Metrics[0];
		this.charts = new Chart[0];
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getCik() {
		return cik;
	}

	public Metrics[] getMetrics() {
		return metrics;
	}

	public Chart[] getCharts() {
		return charts;
	}

	// Methods
	public void sync(String period) {
		// TODO
	}

	public void latestRatios(Ratio ratios) {
		// TODO
	}
}
