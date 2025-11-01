/**
 * 
 */
public class Metrics {
    private FinancialInformation[] financialInformation;

    /**
     * 
     * 
     * @param financialInformation an array of FinancialInformation objects
     */
    public Metrics(FinancialInformation[] financialInformation) {
        this.financialInformation = financialInformation;
    }

    /**
     * Returns the financial information array.
     * 
     * @return the array of FinancialInformation 
     */
    public FinancialInformation[] getFinancialInformation() {
        return financialInformation;
    }

    /**
     * Sets the financial information array.
     * 
     * @param financialInformation the new array of FinancialInformation 
     */
    public void setFinancialInformation(FinancialInformation[] financialInformation) {
        this.financialInformation = financialInformation;
    }
}
