public class Efficiency extends Metrics {
    private double assetTurnover;
    private double inventoryTurnover;

    /**
     * Constructs an Efficiency object.
     * 
     * @param assetTurnover     the asset turnover ratio
     * @param inventoryTurnover the inventory turnover ratio
     */
    public Efficiency(double assetTurnover, double inventoryTurnover) {
        super(null); // no FinancialInformation[] provided
        this.assetTurnover = assetTurnover;
        this.inventoryTurnover = inventoryTurnover;
    }

    /**
     * TODO
     * 
     * @return the asset turnover ratio
     */
    public double getAssetTurnover() {
        return assetTurnover;
    }

    /**
     * TODO
     * 
     * @param assetTurnover the new asset turnover ratio
     */
    public void setAssetTurnover(double assetTurnover) {
        this.assetTurnover = assetTurnover;
    }

    /**
     * TODO
     * 
     * @return the inventory turnover ratio
     */
    public double getInventoryTurnover() {
        return inventoryTurnover;
    }

    /**
     * TODO
     * 
     * @param inventoryTurnover the new inventory turnover ratio
     */
    public void setInventoryTurnover(double inventoryTurnover) {
        this.inventoryTurnover = inventoryTurnover;
    }
}
