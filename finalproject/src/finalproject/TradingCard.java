/**
 * Abstract class representing a generic trading card.
 * Contains basic information like the card's name and collector number.
 */
public abstract class TradingCard {

    private String name;
    private int collectorNumber;

    /**
     * Constructs a TradingCard with the given name and collector number.
     *
     * @param name the name of the card
     * @param collectorNumber the collector number of the card
     */
    public TradingCard(String name, int collectorNumber) {
        this.name = name;
        this.collectorNumber = collectorNumber;
    }

    /**
     * Returns the category of the trading card.
     * Implemented by subclasses like PokemonCard and POkemonDisplayOnlyCard
     *
     * @return the category of the card as a String
     */
    public abstract String getCategory();

    /**
     * Returns the name of the card
     *
     * @return the card's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the collector number of the card
     *
     * @return the collector number
     */
    public int getCollectorNumber() {
        return collectorNumber;
    }

    /**
     * Returns a string representation of the card.
     *
     * @return the card's name followed by its collector number
     */
    @Override
    public String toString() {
        return name + " (#" + collectorNumber + ")";
    }
}
