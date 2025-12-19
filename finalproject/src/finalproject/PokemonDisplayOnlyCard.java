/**
 * Lead Author(s):
 * 
 * @author Nohemi Arquette
 * 
 *         Responsibilities: Represents a "display only" Pokémon card used for
 *         visual collection purposes.
 */

// PokemonDisplayOnlyCard IS-A PokemonCard
public class PokemonDisplayOnlyCard extends PokemonCard {
	private String displayType;

	/**
	 * Constructs a display only Pokémon card.
	 *
	 * @param name            the Pokémon card name
	 * @param collectorNumber the card's collector number
	 * @param type            the display type (Art, Jumbo, ect.)
	 * @throws InvalidInputException if inputs are invalid
	 */
	public PokemonDisplayOnlyCard(String name, String collectorNumber, String type) throws InvalidInputException {
		super(name, collectorNumber, "Display");
		this.displayType = type;
	}

	/**
	 * Returns the display type of this card.
	 *
	 * @return display type
	 */
	public String getDisplayType() {
		return displayType;
	}

	/**
	 * Returns a string representation of the display-only card.
	 *
	 * @return string describing the card
	 */
	@Override
	public String toString() {
		return getCategory() + " Card: " + getName() + " (#" + getCollectorNumber() + ") - Type: " + displayType;
	}
}
