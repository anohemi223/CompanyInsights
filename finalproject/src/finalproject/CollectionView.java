import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Lead Author(s):
 * 
 * @author Nohemi Arquette
 * 
 *         References:
 *         https://docs.oracle.com/javase/tutorial/uiswing/components/index.html
 * 
 *         Responsibilities: GUI for displaying and managing a Pokémon card
 *         collection.
 */

//CollectionView IS-A JFrame
//CollectionView HAS-A Trainer, HAS-A JTable, HAS-A DefaultTableModel, HAS-A JButton
public class CollectionView extends JFrame {

	private Trainer trainer; // Trainer object containing name and favorite Pokémon
	private JLabel trainerNameLabel;
	private JLabel trainerFavPokemonLabel;

	private JButton addCardButton;
	private JButton saveButton;

	private JTable cardTable;
	private DefaultTableModel tableModel;

	/**
	 * Constructor: sets up GUI with trainer info and card collection.
	 *
	 * @param trainer Trainer object containing name and favorite Pokémon
	 */
	public CollectionView(Trainer trainer) {
		super("Pokémon Collection");
		this.trainer = trainer;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		setupTopPanel();
		setupTable();
		setupBottomPanel();

		// Display window
		pack();
		setSize(900, 500);
		setLocationRelativeTo(null);
		setVisible(true);

		// Add card button listener
		addCardButton.addActionListener(e -> addCardDialog());
	}

	/**
	 * Sets up the top panel with trainer info and title.
	 */
	private void setupTopPanel() {
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		topPanel.setBackground(new Color(59, 76, 202));

		// Trainer info
		JPanel trainerPanel = new JPanel();
		trainerPanel.setLayout(new BoxLayout(trainerPanel, BoxLayout.Y_AXIS));
		trainerPanel.setBackground(new Color(59, 76, 202));

		trainerNameLabel = new JLabel("Trainer: " + trainer.getName());
		trainerNameLabel.setForeground(Color.WHITE);
		trainerFavPokemonLabel = new JLabel("Favorite Pokémon: " + trainer.getFavPokemon());
		trainerFavPokemonLabel.setForeground(Color.WHITE);

		trainerPanel.add(trainerNameLabel);
		trainerPanel.add(trainerFavPokemonLabel);

		topPanel.add(trainerPanel, BorderLayout.WEST);

		// Center title
		JLabel titleLabel = new JLabel("Pokémon Collection", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
		titleLabel.setForeground(new Color(255, 222, 0));
		topPanel.add(titleLabel, BorderLayout.CENTER);

		// Add Card button
		addCardButton = new JButton("Add Card");
		addCardButton.setBackground(Color.WHITE);
		JPanel addButtonPanel = new JPanel();
		addButtonPanel.add(addCardButton);
		topPanel.add(addButtonPanel, BorderLayout.EAST);

		add(topPanel, BorderLayout.NORTH);
	}

	/**
	 * Sets up the center table with all necessary categories
	 * 
	 */
	private void setupTable() {
		String[] columnNames = { "Category", "Name", "Collector #", "Set", "Rarity", "Price", "Display Type" };

		tableModel = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Only Set, Rarity, Price editable if card is Playable
				String category = (String) getValueAt(row, 2);
				return category != null && category.equals("Playable") && (column == 3 || column == 4 || column == 5);
			}
		};

		cardTable = new JTable(tableModel);
		cardTable.getTableHeader().setBackground(Color.RED);
		cardTable.getTableHeader().setForeground(Color.WHITE);
		cardTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));

		JScrollPane scrollPane = new JScrollPane(cardTable);
		add(scrollPane, BorderLayout.CENTER);
	}

	/**
	 * Sets up bottom panel with Save button to write collection to CSV file.
	 */
	private void setupBottomPanel() {
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.setBackground(new Color(59, 76, 202));
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		saveButton = new JButton("Save Collection");
		bottomPanel.add(saveButton);
		add(bottomPanel, BorderLayout.SOUTH);

		// Save
		saveButton.addActionListener(e -> {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Save Collection");

			int userSelection = fileChooser.showSaveDialog(this);

			if (userSelection == JFileChooser.APPROVE_OPTION) {
				java.io.File fileToSave = fileChooser.getSelectedFile();
				try (java.io.PrintWriter writer = new java.io.PrintWriter(fileToSave)) {
					for (PokemonCard card : trainer.getCollection().getCollection()) {
						if (card instanceof PokemonDisplayOnlyCard displayCard) {
							// Save "display only" card
							writer.println(card.getName() + "," + card.getCollectorNumber() + ",,,,"
									+ displayCard.getDisplayType());
						} else {
							// Save each stats entry for playable cards
							for (CardStats stats : card.getStats()) {
								writer.println(card.getName() + "," + card.getCollectorNumber() + ","
										+ stats.getSetName() + "," + stats.getRarity() + "," + stats.getPrice() + ",");
							}
						}
					}
					JOptionPane.showMessageDialog(this, "Collection saved!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Error saving collection: " + ex.getMessage());
				}
			}

		});
	}

	/**
	 * Opens dialogs to input card info and adds it to the collection and table.
	 * Each field is independently checked for exceptions and repromts as necessary.
	 */
	private void addCardDialog() {
		try {

			// Get Pokémon name
			String name = null;
			while (name == null) {
				try {
					name = getLettersOnlyInput("Enter Card name:");
					if (name == null)
						return; // Cancel exits
				} catch (InvalidInputException ex) {
					JOptionPane.showMessageDialog(this, ex.getMessage());
					// reprompt same field
				}
			}

			// Get collector number
			String collectorNumber = null;
			while (collectorNumber == null) {
				collectorNumber = JOptionPane.showInputDialog(this, "Enter Collector #:");
				if (collectorNumber == null)
					return; // user pressed cancel
				if (collectorNumber.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Field cannot be empty.");
					collectorNumber = null; // reprompt
				}
			}
			// Select category
			String[] categories = { "Playable", "Display" };
			int catChoice = JOptionPane.showOptionDialog(this, "Select Category:", "Card Category",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, categories, categories[0]);
			if (catChoice == JOptionPane.CLOSED_OPTION)
				return; // Cancel exits
			String category = categories[catChoice];

			if (category.equals("Display")) {
				// Display card input
				String displayType = null;
				while (displayType == null) {
					try {
						displayType = getLettersOnlyInput("Enter Card Display Type:");
						if (displayType == null)
							return; // Cancel exits
					} catch (InvalidInputException ex) {
						JOptionPane.showMessageDialog(this, ex.getMessage());
						// reprompt same field
					}
				}

				PokemonDisplayOnlyCard displayCard = new PokemonDisplayOnlyCard(name, collectorNumber, displayType);
				trainer.addCardToCollection(displayCard);
				addCardToTable(displayCard);

			} else {
				// Playable card input
				String setName = null;
				while (setName == null) {
					try {
						setName = getLettersOnlyInput("Enter Set name:");
						if (setName == null)
							return;
					} catch (InvalidInputException ex) {
						JOptionPane.showMessageDialog(this, ex.getMessage());
					}
				}

				String rarity = null;
				while (rarity == null) {
					try {
						rarity = getLettersOnlyInput("Enter Rarity:");
						if (rarity == null)
							return;
					} catch (InvalidInputException ex) {
						JOptionPane.showMessageDialog(this, ex.getMessage());
					}
				}

				Double price = null;
				while (price == null) {
					try {
						price = getNonNegativeDouble("Enter Price:");
						if (price == null)
							return;
					} catch (InvalidInputException ex) {
						JOptionPane.showMessageDialog(this, ex.getMessage());
					}
				}

				PokemonCard card = new PokemonCard(name, collectorNumber, category);
				card.addOrUpdateStats(new CardStats(setName, rarity, price, collectorNumber));
				trainer.addCardToCollection(card);
				addCardToTable(card);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Unexpected error: " + ex.getMessage());
		}
	}

	/**
	 * Adds a card to the Table.
	 *
	 * @param card PokemonCard to add
	 */
	public void addCardToTable(PokemonCard card) {
		if (card instanceof PokemonDisplayOnlyCard displayCard) {
			tableModel.addRow(new Object[] { card.getCategory(), // Category
					card.getName(), // Name
					card.getCollectorNumber(), // Collector #
					"N/A", // No set
					"N/A", // No Rarity
					"N/A", // No price
					displayCard.getDisplayType() // Display Type
			});
		} else {
			for (CardStats stats : card.getStats()) {
				tableModel.addRow(new Object[] { card.getCategory(), // Category
						card.getName(), // Name
						card.getCollectorNumber(), // Collector #
						stats.getSetName(), // Set
						stats.getRarity(), // Rarity
						stats.getPrice(), // Price
						"N/A" // No Display
				});
			}
		}
	}

	/**
	 * Prompts the user for a string containing only letters.
	 *
	 * @param prompt the message to display in input dialog
	 * @return validated string input
	 * @throws InvalidInputException if input is invalid
	 */
	private String getLettersOnlyInput(String prompt) throws InvalidInputException {
		while (true) {
			String input = JOptionPane.showInputDialog(this, prompt);
			if (input == null)
				return null; // Cancel pressed
			input = input.trim();
			if (input.isEmpty())
				throw new InvalidInputException("Field cannot be empty.");
			if (!input.matches("[a-zA-Z ]+"))
				throw new InvalidInputException("Enter only letters.");
			return input;
		}
	}

	/**
	 * Prompts the user for a non-negative double.
	 *
	 * @param prompt the message to display in input dialog
	 * @return validated double input
	 * @throws InvalidInputException if input is invalid
	 */
	private Double getNonNegativeDouble(String prompt) throws InvalidInputException {
		while (true) {
			String input = JOptionPane.showInputDialog(this, prompt);
			if (input == null)
				return null; // Cancel pressed
			input = input.trim();
			if (input.isEmpty())
				throw new InvalidInputException("Field cannot be empty.");
			try {
				double value = Double.parseDouble(input);
				if (value < 0)
					throw new InvalidInputException("Value cannot be negative.");
				return value;
			} catch (NumberFormatException e) {
				throw new InvalidInputException("Must be a valid number.");
			}
		}
	}

	// Getters
	/**
	 * Returns an add card button
	 *
	 * @return button the button to add more cards
	 */
	public JButton getAddButton() {
		return addCardButton;
	}
	/**
	 * Returns a save button button
	 *
	 * @return button the button to save collection
	 */
	public JButton getSaveButton() {
		return saveButton;
	}
	/**
	 * Returns a table model
	 *
	 * @return tableModel the Default table to add cards to
	 */
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
}
