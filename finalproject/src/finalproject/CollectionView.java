import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 * GUI for displaying and managing a Pokémon card collection.
 */
public class CollectionView extends JFrame {

    private Trainer trainer; // Trainer object containing name, favorite Pokémon, and collection
    private JLabel trainerNameLabel;
    private JLabel trainerFavPokemonLabel;

    private JButton addCardButton;
    private JButton saveButton;

    private JTable cardTable;
    private DefaultTableModel tableModel;

    /**
     * Constructor: sets up GUI with trainer info and card collection.
     * @param trainer Trainer object containing name, favorite Pokémon, and collection
     */
    public CollectionView(Trainer trainer) {
        super("Pokémon Collection");
        this.trainer = trainer;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Top Panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.setBackground(Color.WHITE);

        // Left Panel: Trainer Info
        JPanel trainerPanel = new JPanel();
        trainerPanel.setLayout(new BoxLayout(trainerPanel, BoxLayout.Y_AXIS));
        trainerPanel.setBackground(Color.WHITE);

        trainerNameLabel = new JLabel("Trainer: " + trainer.getName());
        trainerFavPokemonLabel = new JLabel("Favorite Pokémon: " + trainer.getFavPokemon());

        trainerPanel.add(trainerNameLabel);
        trainerPanel.add(trainerFavPokemonLabel);

        topPanel.add(trainerPanel, BorderLayout.WEST);

        // Center title
        JLabel titleLabel = new JLabel("Pokémon Collection", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Right Add Card button
        addCardButton = new JButton("Add Card");
        JPanel addButtonPanel = new JPanel();
        addButtonPanel.setBackground(Color.WHITE);
        addButtonPanel.add(addCardButton);
        topPanel.add(addButtonPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // Center Table
        String[] columnNames = {"Name", "Collector #", "Set", "Rarity", "Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        cardTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(cardTable);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel: Save Collection button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(Color.WHITE);
        saveButton = new JButton("Save Collection");
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.add(saveButton);
        add(bottomPanel, BorderLayout.SOUTH);
     // Add action listener for saving
        saveButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Collection");

            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File fileToSave = fileChooser.getSelectedFile();
                try (java.io.PrintWriter writer = new java.io.PrintWriter(fileToSave)) {
                    for (PokemonCard card : trainer.getCollection().getCollection()) {
                        for (CardStats stats : card.getStats()) {
                            writer.println(card.getName() + "," +
                                           card.getCollectorNumber() + "," +
                                           stats.getSetName() + "," +
                                           stats.getRarity() + "," +
                                           stats.getPrice());
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Collection saved!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error saving collection: " + ex.getMessage());
                }
            }
        });
        // Pack, size, and display
        pack();
        setSize(900, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        // Add card button listener
        addCardButton.addActionListener(e -> addCardDialog());
    }

    /**
     * Opens dialogs to input card info and adds it to the collection and table.
     */
    private void addCardDialog() {
        try {
            // Card name
            String name = JOptionPane.showInputDialog(this, "Enter Pokémon name:");
            if (name == null || name.isBlank()) return;

            // Collector number with validation
            int collectorNumber = -1;
            while (collectorNumber < 0) {
                String collectorStr = JOptionPane.showInputDialog(this, "Enter Collector # (whole number >= 0):");
                if (collectorStr == null) return;
                try {
                    collectorNumber = Integer.parseInt(collectorStr);
                    if (collectorNumber < 0) {
                        JOptionPane.showMessageDialog(this, "Collector number can't be negative.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid number. Please enter a whole number.");
                }
            }

            // Set name TODO(Name needs exception handling to not allow #'s)
            String setName = JOptionPane.showInputDialog(this, "Enter Set name:");
            if (setName == null) return;

            // Rarity TODO (rarity needs exception handling to not allow #'s)
            String rarity = JOptionPane.showInputDialog(this, "Enter Rarity:");
            if (rarity == null) return;

            // Price with validation
            double price = -1;
            while (price < 0) {
                String priceStr = JOptionPane.showInputDialog(this, "Enter Price (>= 0):");
                if (priceStr == null) return;
                try {
                    price = Double.parseDouble(priceStr);
                    if (price < 0) {
                        JOptionPane.showMessageDialog(this, "Price can't be negative.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid price format. Please enter a number.");
                }
            }

            // Create card and stats
            PokemonCard card = new PokemonCard(name, collectorNumber);
            card.addOrUpdateStats(new CardStats(setName, rarity, price, collectorNumber));

            // Add to trainer's collection
            trainer.addCardToCollection(card);

            // Add to table
            addCardToTable(card);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error adding card: " + ex.getMessage());
        }
    }

    /**
     * Adds a card to the visible JTable.
     * @param card PokemonCard to add
     */
    public void addCardToTable(PokemonCard card) {
        for (CardStats stats : card.getStats()) {
            tableModel.addRow(new Object[]{
                    card.getName(),
                    stats.getCollectorNumber(),
                    stats.getSetName(),
                    stats.getRarity(),
                    stats.getPrice()
            });
        }
    }

    public JButton getAddButton() {
        return addCardButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
