public class Profitability extends Metrics {
    private double grossMargin;
    private double operatingMargin;

    /**
     * Constructs a Profitability object.
     * 
     * @param grossMargin      
     * @param operatingMargin  
     * @param Metrics 
     */
    public Profitability(double grossMargin, double operatingMargin, FinancialInformation[] Metrics) {
        super(Metrics); // TODO fix??
        this.grossMargin = grossMargin;
        this.operatingMargin = operatingMargin;
    }

    /**
     * Returns the gross margin.
     * 
     * @return the gross margin
     */
    public double getGrossMargin() {
        return grossMargin;
    }

    /**
     * Sets the gross margin.
     * 
     * @param grossMargin the new gross margin
     */
    public void setGrossMargin(double grossMargin) {
        this.grossMargin = grossMargin;
    }

    /**
     * Returns the operating margin.
     * 
     * @return the operating margin
     */
    public double getOperatingMargin() {
        return operatingMargin;
    }

    /**
     * Sets the operating margin.
     * 
     * @param operatingMargin the new operating margin
     */
    public void setOperatingMargin(double operatingMargin) {
        this.operatingMargin = operatingMargin;
    }
}
