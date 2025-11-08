

/**
 * 
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionManager {

	private List<PokemonCard> collection;

	public CollectionManager() {
		this.collection = new ArrayList<>();
	}

	public List<PokemonCard> getCollection() {
		return collection;
	}

	public void addCard(PokemonCard card) {
		for (int i = 0; i < collection.size(); i++) {
			PokemonCard existingCard = collection.get(i);

			// Compare both name and collector number
			if (existingCard.getName().equalsIgnoreCase(card.getName())) {
				// Check card stats for matching collectorNumber
				for (CardStats newStats : card.getStats()) {
					existingCard.addOrUpdateStats(newStats);
				}
				return;
			}
		}

		// If no matching card name/collector number combo found, add new card
		collection.add(card);
	}

	public void displayCollection() {
		for (PokemonCard card : collection) {
			System.out.println(card);
		}
	}
}
