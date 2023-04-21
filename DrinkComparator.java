import java.util.Comparator;

public class DrinkComparator implements Comparator<DrinkHashTable> {
    @Override
    public int compare(DrinkHashTable drink1, DrinkHashTable drink2) {
        int priceComparison = Double.compare(drink1.getPrice(), drink2.getPrice());
        if (priceComparison != 0) {
            return priceComparison;
        }
        return drink1.getName().compareTo(drink2.getName());
    }
}
