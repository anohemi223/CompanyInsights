/**
 * 
 */

public class Chart {
    private FinancialInformation[] financialInformation;

    // Constructor
    public Chart(FinancialInformation[] financialInformation) {
        this.financialInformation = financialInformation;
    }

    // Getter and setter
    public FinancialInformation[] getFinancialInformation() {
        return financialInformation;
    }

    public void setFinancialInformation(FinancialInformation[] financialInformation) {
        this.financialInformation = financialInformation;
    }
}

