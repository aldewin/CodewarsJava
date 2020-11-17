/**
 * Josephus Survivor
 *
 * https://www.codewars.com/kata/555624b601231dc7a400017a/train/java
 */

package codewarsKyu5;

import java.util.ArrayList;
import java.util.List;

public class KataJosephusSurvivor {
    public static void main(String[] args) {
        System.out.println(josephusSurvivor(100, 1));
    }

    public static int josephusSurvivor(final int n, final int k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            numbers.add(i);

        int lengthList = numbers.size();
        int delta = k - 1;
        int removeElement = delta;
        while (lengthList != 1) {
            while (removeElement >= lengthList)
                removeElement -= lengthList;

            numbers.remove(removeElement);
            lengthList--;

            removeElement += delta;
        }
        return numbers.get(0);
    }
}
