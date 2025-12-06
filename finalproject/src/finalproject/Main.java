import javax.swing.*;
import java.awt.Image;

/**
 * Main class to launch the Pokémon Collection application.
 * Asks the user for trainer information and starts the GUI.
 */
public class Main {

    public static void main(String[] args) {
        // Add image icon to dialogue box 
        ImageIcon pokeballIcon = new ImageIcon(CollectionView.class.getResource("/images/pokeball-png-45354.png"));
        Image scaledImage = pokeballIcon.getImage().getScaledInstance(75, 65, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Ask for trainer info using dialogs
        String name = (String) JOptionPane.showInputDialog(
                null,
                "Enter your name:",
                "Trainer Name",
                JOptionPane.QUESTION_MESSAGE,
                scaledIcon, 
                null,
                ""
        );

        if (name == null || name.isBlank()) return;

        String favPokemon = (String) JOptionPane.showInputDialog(
                null,
                "Enter your favorite Pokémon:",
                "Favorite Pokémon",
                JOptionPane.QUESTION_MESSAGE,
                scaledIcon, 
                null,
                ""
        );

        if (favPokemon == null || favPokemon.isBlank()) return;

        // Create Trainer object
        Trainer trainer = new Trainer(name, favPokemon);

        // Launch GUI
        SwingUtilities.invokeLater(() -> new CollectionView(trainer));
    }
}
