// https://users.cis.fiu.edu/~weiss/dsaajava3/code/Sort.java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrinkSorter {

    public static List<Drink> sortDrinks(List<Drink> drinks) {
        Drink[] drinksArray = drinks.toArray(new Drink[0]);
        Drink[] tmpArray = new Drink[drinks.size()];
        DrinkComparator drinkComparator = new DrinkComparator();

        mergeSort(drinksArray, tmpArray, 0, drinks.size() - 1, drinkComparator);
        return new ArrayList<>(Arrays.asList(drinksArray));
    }

    private static void mergeSort(Drink[] a, Drink[] tmpArray, int left, int right, DrinkComparator comparator) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center, comparator);
            mergeSort(a, tmpArray, center + 1, right, comparator);
            merge(a, tmpArray, left, center + 1, right, comparator);
        }
    }

    private static void merge(Drink[] a, Drink[] tmpArray, int leftPos, int rightPos, int rightEnd,
            DrinkComparator comparator) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (comparator.compare(a[leftPos], a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }
}
