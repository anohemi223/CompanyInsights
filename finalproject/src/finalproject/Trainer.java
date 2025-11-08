import java.util.Scanner;

/**
 * Represents a Pokémon Trainer with a name, email, and collection of cards.
 */
public class Trainer {
    private String name;
    private String email;
    private CollectionManager collection;

    /**
     *Trainer w/ name and email
     * @param name  the trainer's name
     * @param email the trainer's email
     */
    public Trainer(String name, String email) {
        this.name = name;
        this.email = email;
        this.collection = new CollectionManager();
    }

    /**
     * @return the trainer's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the trainer's email
     */
    public String getEmail() {
        return email;
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
        System.out.println("Trainer: " + name + " | Email: " + email);
        System.out.println("Collection:");
        collection.displayCollection();
    }
}

}

