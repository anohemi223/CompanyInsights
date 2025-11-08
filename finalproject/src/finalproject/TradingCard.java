/**
 * 
 */

/**
 * 
 */
public abstract class TradingCard {
    private String name;
    private int collectorNumber;

    public TradingCard(String name, int collectorNumber) {
        this.name = name;
        this.collectorNumber = collectorNumber;
    }

	    
	    public abstract String getCategory();

	    public String getName() {
	        return name;
	    }

	    public int getCollectorNumber() {
	        return collectorNumber;
	    }

	    @Override
	    public String toString() {
	        return name + " (#" + collectorNumber + ")";
	    }
	}
