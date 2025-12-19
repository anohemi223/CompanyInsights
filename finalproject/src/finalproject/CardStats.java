/**
 * Lead Author(s):
 * 
 * @author Nohemi Arquette
 * 
 *         Responsibilities: Represents statistical details for a Pokémon card.
 */

public class CardStats {
	private String setName;
	private String rarity;
	private double price;
	private String collectorNumber;

	/**
	 * Constructs a CardStats object with a set name, rarity, price, and collector
	 * number.
	 *
	 * @param setName          the name of the card set
	 * @param rarity           the rarity of the card
	 * @param price            the market price of the card
	 * @param collectorNumber2 the unique collector number within the set
	 */
	public CardStats(String setName, String rarity, double price, String collectorNumber) {
		this.setName = setName;
		this.rarity = rarity;
		this.price = price;
	}

	// getters

	/**
	 * Returns the name of the card set.
	 *
	 * @return the set name
	 */
	public String getSetName() {
		return setName;
	}

	/**
	 * Returns the rarity of the card.
	 *
	 * @return the card rarity
	 */
	public String getRarity() {
		return rarity;
	}

	/**
	 * Returns the market price of the card.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Returns the collector number of the card.
	 *
	 * @return the collector number
	 */
	public String getCollectorNumber() {
		return collectorNumber;
	}

//setters
	/**
	 * Sets the name of the card set.
	 *
	 * @param setName the new set name
	 */
	public void setSetName(String setName) {
		this.setName = setName;
	}

	/**
	 * Sets the rarity of the card.
	 *
	 * @param rarity the new rarity
	 */
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	/**
	 * Sets the market price of the card.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Sets the collector number of the card.
	 *
	 * @param collectorNumber the new collector number
	 */
	public void setCollectorNumber(String collectorNumber) {
		this.collectorNumber = collectorNumber;
	}

	/**
	 * Returns a string representation of the card stats.
	 *
	 * @return a string containing rarity, set name, and price
	 */
	@Override
	public String toString() {
		return rarity + " (" + setName + ") - $" + price;
	}
}
	@Override
	public String toString() {
		return rarity + " (" + setName + ") - $" + price;
	}
}
