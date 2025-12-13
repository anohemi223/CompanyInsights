public class PokemonDisplayOnlyCard extends PokemonCard {
    private String displayType;

    public PokemonDisplayOnlyCard(String name, String collectorNumber, String type) throws InvalidInputException {
        super(name, collectorNumber, "Display");
        this.displayType = type;
    }

    public String getDisplayType() {
        return displayType;
    }

    @Override
    public String toString() {
        return getCategory() + " Card: " + getName() + " (#" + getCollectorNumber() + ") - Type: " + displayType;
    }
}
