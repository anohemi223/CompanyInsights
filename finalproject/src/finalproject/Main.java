import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Ask for trainer info using dialogs
        String name = JOptionPane.showInputDialog(null, "Enter your name:");
        if (name == null || name.isBlank()) return;

        String favPokemon = JOptionPane.showInputDialog(null, "Enter your favorite Pokémon:");
        if (favPokemon == null || favPokemon.isBlank()) return;

        // Create Trainer object
        Trainer trainer = new Trainer(name, favPokemon);

        // Launch GUI
        SwingUtilities.invokeLater(() -> new CollectionView(trainer));
    }
}
