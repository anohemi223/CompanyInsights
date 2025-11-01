/**
 * 
 */

public class FinancialInformation {
    private String assets;
    private String liabilities;
    private double revenue;
    private int cost;
    private int netIncome;
    private int period;

    /**
     * Constructs a FinancialInformation object with the given values.
     * 
     * @param assets       
     * @param liabilities  
     * @param revenue      
     * @param cost         
     * @param netIncome  
     * @param period       
     */
    public FinancialInformation(String assets, String liabilities, double revenue, int cost, int netIncome, int period) {
        this.assets = assets;
        this.liabilities = liabilities;
        this.revenue = revenue;
        this.cost = cost;
        this.netIncome = netIncome;
        this.period = period;
    }

    // Getters and setters
    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets;
    }

    public String getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(String liabilities) {
        this.liabilities = liabilities;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(int netIncome) {
        this.netIncome = netIncome;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}

