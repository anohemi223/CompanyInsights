
/**
 * Lead Author(s):
 * 
 * @author Nohemi Arquette
 * 
 *         Responsibilities: Represents a Pokémon Trainer with a name, favorite
 *         Pokemon , and collection of cards.
 */

// Trainer HAS-A Collection Manager
public class Trainer {
	private String name;
	private CollectionManager collection;
	private String favPokemon;

	/**
	 * Trainer w/ name and favorite Pokémon
	 * 
	 * @param name       the trainer's name
	 * @param favPokemon the trainer's favorite Pokémon
	 */
	public Trainer(String name, String favPokemon) {
		this.name = name;
		this.favPokemon = favPokemon;
		this.collection = new CollectionManager();
	}

	/**
	 * @return the trainer's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the trainer's favorite Pokémon
	 */
	public String getFavPokemon() {
		return favPokemon;
	}

	/**
	 * @return the trainer's collection manager
	 */
	public CollectionManager getCollection() {
		return collection;
	}

	/**
	 * Adds a card to the trainer's collection.
	 *
	 * @param card the Pokémon card to add
	 */
	public void addCardToCollection(PokemonCard card) {
		collection.addCard(card);
	}

	/**
	 * Displays the trainer's information and all cards in their collection.
	 */
	public void displayTrainerInfo() {
		System.out.println("Trainer: " + name + " | Favorite Pokemon: " + favPokemon);
		System.out.println("Collection:");
		collection.displayCollection();
	}
}

