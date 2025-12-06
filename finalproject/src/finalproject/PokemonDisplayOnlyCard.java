public class PokemonDisplayOnlyCard extends TradingCard {
    private String displayType; // e.g., "Oversize", "Jumbo", "Art Card"

    /**
     * Constructs a DisplayCard with a name, collector number, and display type.
     */
    public PokemonDisplayOnlyCard(String name, int collectorNumber, String type) {
        super(name, collectorNumber);
        this.displayType = type;
    }

    /**
     * Returns card category
     */
    @Override
    public String getCategory() {
        return "Display / Oversize";
    }

    /**
     * Returns the display type of card
     */
    public String getDisplayType() {
        return displayType;
    }

    /**
     * Sets the display type of card
     */
    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    @Override
    public String toString() {
        return getCategory() + " Card: " + getName() + " (#" + getCollectorNumber() + ") - Type: " + displayType;
    }
}
