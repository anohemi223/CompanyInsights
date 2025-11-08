/**
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class PokemonCard extends TradingCard {
    private List<CardStats> stats;

    public PokemonCard(String name, int collectorNumber) {
        super(name, collectorNumber);
        this.stats = new ArrayList<>();
    }


    public List<CardStats> getStats() {
        return stats;
    }

    // Add / update cards
    public void addOrUpdateStats(CardStats newStats) {
        for (int i = 0; i < stats.size(); i++) {
            CardStats currentStats  = stats.get(i);
            if (currentStats.getCollectorNumber() == newStats.getCollectorNumber()) {
                currentStats.setPrice(newStats.getPrice());
                currentStats.setRarity(newStats.getRarity());
                currentStats.setSetName(newStats.getSetName());
                return;
            }
        }
        stats.add(newStats);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getCategory() + " Card: " + getName() + " (#" + getCollectorNumber() + ")\n");
        for (int i = 0; i < stats.size(); i++) {
            sb.append("   ").append(stats.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
		public String getCategory() {
		    return "Pokémon";
		}

		
	}
