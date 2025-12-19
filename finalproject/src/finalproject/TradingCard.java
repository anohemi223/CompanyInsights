
/**
 * Lead Author(s):
 * 
 * @author Nohemi Arquette
 * 
 *         Responsibilities: Abstract class representing a generic trading card.
 *         Contains basic information like the card's name and collector number.
 */

// TradingCard IS-A abstract class
public abstract class TradingCard {

	private String name;
	private String collectorNumber;

	/**
	 * Constructs a TradingCard with the given name and collector number.
	 *
	 * @param name             the name of the card
	 * @param collectorNumber2 the collector number of the card
	 */
	public TradingCard(String name, String collectorNumber2) {
		this.name = name;
		this.collectorNumber = collectorNumber2;
	}

	/**
	 * Returns the category of the trading card. Implemented by subclasses like
	 * PokemonCard and POkemonDisplayOnlyCard
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
	public String getCollectorNumber() {
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

