import java.util.Scanner;

public class CardInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CollectionManager collectionManager = new CollectionManager();

        System.out.println("Welcome Trainer to your Pokémon card collection!");

        boolean adding = true;

        while (adding) {
            // Basic card info input by user
            System.out.print("Enter card name: ");
            String name = scanner.nextLine();

            System.out.print("Enter collector number: ");
            int collectorNumber = Integer.parseInt(scanner.nextLine());

            PokemonCard card = new PokemonCard(name, collectorNumber);

            // Card stats input
            System.out.print("Enter set name: ");
            String setName = scanner.nextLine();

            System.out.print("Enter rarity: ");
            String rarity = scanner.nextLine();

            System.out.print("Enter price: ");
            double price = Double.parseDouble(scanner.nextLine());

            CardStats stats = new CardStats(setName, rarity, price, collectorNumber);
            card.addOrUpdateStats(stats);

            //Adds card to collection
            collectionManager.addCard(card);

            // Ability to input more cards
            System.out.print("Add another card? (y/n): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                adding = false;
            }
        }

        // Display collection
        System.out.println("\nYour collection:");
        collectionManager.displayCollection();

        scanner.close();
    }
}
