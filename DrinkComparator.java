import java.util.Comparator;

// comparator for drinks to sort by price and then name
public class DrinkComparator implements Comparator<Drink> {
    @Override
    public int compare(Drink drink1, Drink drink2) {
        int priceComparison = Double.compare(drink1.getPrice(), drink2.getPrice());
        if (priceComparison != 0) {
            return priceComparison;
        }
        return drink1.getName().compareTo(drink2.getName());
    }
}
