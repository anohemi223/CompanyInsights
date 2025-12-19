
import java.util.ArrayList;
import java.util.List;

/**
 * Lead Author(s):
 * 
 * @author Nohemi Arquette
 * 
 *         Responsibilities: Represents a playable Pokémon trading card with
 *         imported statistics.
 */

//PokemonCard IS-A TradingCard
//PokemonCard HAS-A List<CardStats>
public class PokemonCard extends TradingCard {
	private List<CardStats> stats;
	private String category;

	/**
	 * Constructs a PokemonCard with a name, collector number, and category.
	 *
	 * @param name            the Pokémon card name
	 * @param collectorNumber the card's collector number
	 * @param category        the card's category
	 * @throws InvalidInputException if inputs are invalid
	 */
	public PokemonCard(String name, String collectorNumber, String category) throws InvalidInputException {
		super(name, collectorNumber);
		this.category = category;
		this.stats = new ArrayList<>();
	}

	/**
	 * Returns the list of CardStats for the specified card.
	 *
	 * @return List of CardStats
	 */
	public List<CardStats> getStats() {
		return stats;
	}

	/**
	 * Adds a new CardStats or updates existing statistics. Statistics are matched
	 * by collector number.
	 *
	 * @param newStats the CardStats to add or update
	 */
	public void addOrUpdateStats(CardStats newStats) {
		for (int i = 0; i < stats.size(); i++) {
			CardStats currentStats = stats.get(i);
			if (currentStats.getCollectorNumber().equals(newStats.getCollectorNumber())) {
				currentStats.setPrice(newStats.getPrice());
				currentStats.setRarity(newStats.getRarity());
				currentStats.setSetName(newStats.getSetName());
				return;
			}
		}
		stats.add(newStats);
	}

	/**
	 * Returns the category of card.
	 *
	 * @return the category as a String
	 */
	@Override
	public String getCategory() {
		return category;
	}

	/**
	 * Returns a string representation of the card and its statistics.
	 *
	 * @return string of the card
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(
				getCategory() + " Card: " + getName() + " (#" + getCollectorNumber() + ")\n");
		for (int i = 0; i < stats.size(); i++) {
			sb.append("   ").append(stats.get(i).toString()).append("\n");
		}
		return sb.toString();
	}
}
