

/**
 * 
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionManager {

	private List<PokemonCard> collection;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of Pokémon cards for a trainer.
 * Provides functionality to add cards, retrieve the collection, and display it.
 */
public class CollectionManager {

    private List<PokemonCard> collection;
    private String trainerName;
    private String trainerFavPokemon;

    /**
     * Default constructor initializes an empty collection.
     */
    public CollectionManager() {
        this.collection = new ArrayList<>();
    }

    /**
     * Constructor initializes a collection for a trainer with a given name.
     * 
     * @param trainerName Name of the trainer
     */
    public CollectionManager(String trainerName) {
        this.trainerName = trainerName;
        this.collection = new ArrayList<>();
    }

    /**
     * Returns the list of Pokémon cards in the collection.
     * 
     * @return List of PokemonCard objects
     */
    public List<PokemonCard> getCollection() {
        return collection;
    }

    /**
     * Adds a Pokémon card to the collection.
     * If a card with the same name already exists, its stats are updated instead.
     * 
     * @param card The PokemonCard to add or update
     */
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

    /**
     * Prints the Pokémon collection
     */
    public void displayCollection() {
        for (PokemonCard card : collection) {
            System.out.println(card);
        }
    }

    /**
     * Returns the trainer's name.
     * 
     * @return trainerName
     */
    public String getTrainerName() {
        return trainerName; 
    }
}
