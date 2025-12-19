import javax.swing.*;
import java.awt.Image;

/**
 * Lead Author(s):
 * 
 * @author Nohemi Arquette
 * 
 *         Responsibilities: Main class to launch the Pokémon Collection
 *         application. Asks the user for trainer information and starts the
 *         GUI.
 */

public class Main {
	/**
	 * Main: asks for trainer name and favorite Pokémon, creates a Trainer object,
	 * and launches the CollectionView GUI.
	 *
	 * @param args not used
	 */
	public static void main(String[] args) {
		// Add image icon to dialogue box
		ImageIcon pokeballIcon = new ImageIcon(CollectionView.class.getResource("/images/pokeball-png-45354.png"));
		Image scaledImage = pokeballIcon.getImage().getScaledInstance(75, 65, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Ask for trainer info using dialogs
		String name = (String) JOptionPane.showInputDialog(null, "Enter your name:", "Trainer Name",
				JOptionPane.QUESTION_MESSAGE, scaledIcon, null, "");
		// Exit if canceled or blank
		if (name == null || name.isBlank())
			return;
		// Ask trainer for favorite Pokemon
		String favPokemon = (String) JOptionPane.showInputDialog(null, "Enter your favorite Pokémon:",
				"Favorite Pokémon", JOptionPane.QUESTION_MESSAGE, scaledIcon, null, "");
		// Exit if canceled or left empty
		if (favPokemon == null || favPokemon.isBlank())
			return;

		// Create Trainer object
		Trainer trainer = new Trainer(name, favPokemon);

		// Launch GUI
		SwingUtilities.invokeLater(() -> new CollectionView(trainer));
	}
}
