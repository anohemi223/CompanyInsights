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

            int collectorNumber = 0;
            //event handling to ensure proper input format is followed
            while (true) {
                try {
                    System.out.print("Enter collector number: ");
                    collectorNumber = Integer.parseInt(scanner.nextLine());
                    
                    if (collectorNumber < 0) {
                        System.out.println("Collector number can't be negative.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please enter a whole number.");
                }
            }

            PokemonCard card = new PokemonCard(name, collectorNumber);

            // Card stats input
            System.out.print("Enter set name: ");
            String setName = scanner.nextLine();

            System.out.print("Enter rarity: ");
            String rarity = scanner.nextLine();

            System.out.print("Enter price: ");
            double price = 0;
            // event handling to ensure proper input format is followed
            while (true) {
                try {
                    System.out.print("Enter price: ");
                    price = Double.parseDouble(scanner.nextLine());

                    if (price < 0) {
                        System.out.println("Price can't be negative.");
                        continue; 
                    }

                    break; 
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price format. Please enter a number.");
                }
            }

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
