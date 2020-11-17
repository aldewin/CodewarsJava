/**
 * 4 kyu Next smaller number with the same digits
 *
 * https:ata//www.codewars.com/kata/5659c6d896bc135c4c00021e/train/java
 */

package codewarsKyu4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KataNextSmallerNumber {
    public static void main(String[] args) {
        System.out.println(nextSmaller(531));
    }

    public static long nextSmaller(long n) {
        char[] symbol = Long.toString(n).toCharArray();

        int[] number = new int[symbol.length];
        for (int i = 0; i < symbol.length; i++)
            number[i] = Character.digit(symbol[i], 10);

        int startIndex = -1;
        for (int i = number.length - 2; i >= 0; i--) {
            int maxNumber = i == 0 ? 0 : -1;
            int maxIndex = -1;
            for (int j = i + 1; j < number.length; j++) {
                if (number[i] > number[j] && number[j] > maxNumber) {
                    maxIndex = j;
                    maxNumber = number[j];
                }
            }

            if (maxIndex != -1) {
                int swap = number[i];
                number[i] = maxNumber;
                number[maxIndex] = swap;

                startIndex = i;
                break;
            }
        }

        if (startIndex == -1)
            return -1;

        sortArray(number, startIndex);

        StringBuilder result = new StringBuilder();
        for (int value : number) {
            result.append(value);
        }

        return Long.parseLong(result.toString());
    }

    private static void sortArray(int[] number, int index) {
        List<Integer> sort = new ArrayList<>();

        for (int i = index + 1; i < number.length; i++) {
            sort.add(number[i]);
        }

        Collections.sort(sort);

        int count = sort.size() - 1;
        for (int i = index + 1; i < number.length; i++) {
            number[i] = sort.get(count);
            count--;
        }
    }
}


// 138 718 212 131
// 138 718 212 311
