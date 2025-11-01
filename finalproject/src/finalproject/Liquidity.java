public class Liquidity extends Metrics {
    private double currentRatio;
    private double quickRatio;

    /**
     * Constructs a Liquidity object.
     * 
     * @param currentRatio the current ratio
     * @param quickRatio   the quick ratio
     */
    public Liquidity(double currentRatio, double quickRatio) {
        super(null); // no FinancialInformation[] provided
        this.currentRatio = currentRatio;
        this.quickRatio = quickRatio;
    }

    /**
     * Returns the current ratio.
     * 
     * @return the current ratio
     */
    public double getCurrentRatio() {
        return currentRatio;
    }

    /**
     * Sets the current ratio.
     * 
     * @param currentRatio the new current ratio
     */
    public void setCurrentRatio(double currentRatio) {
        this.currentRatio = currentRatio;
    }

    /**
     * Returns the quick ratio.
     * 
     * @return the quick ratio
     */
    public double getQuickRatio() {
        return quickRatio;
    }

    /**
     * Sets the quick ratio.
     * 
     * @param quickRatio the new quick ratio
     */
    public void setQuickRatio(double quickRatio) {
        this.quickRatio = quickRatio;
    }
}
