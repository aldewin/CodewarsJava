/**
 * 6 kyu
 * Not prime numbers
 *
 * You are given two positive integers a and b (a < b <= 20000). Complete the function which returns a list of all those numbers in the interval [a, b) whose digits are made up of prime numbers (2, 3, 5, 7) but which are not primes themselves.
 *
 * Be careful about your timing!
 */

package codewarsKyu6;

import java.util.ArrayList;
import java.util.List;

public class KataNotPrimeNumbers {
    public static void main(String[] args) {
        System.out.println(notPrimes(2, 222));
    }

    public static List<Integer> notPrimes(int a, int b) {
        List<Integer> digitPrimes = new ArrayList<>();

        if (a < 10) a = 22;
        for (int i = a; i < b; i++) {
            String numberString = String.valueOf(i);
            boolean digitIsPrime = true;
            for (int j = 0; j < numberString.length(); j++) {
                if (numberString.charAt(j) != '2' && numberString.charAt(j) != '3' &&
                        numberString.charAt(j) != '5' && numberString.charAt(j) != '7') {
                    digitIsPrime = false;
                    break;
                }
            }
            if (digitIsPrime) {
                boolean numberIsNotPrime = false;
                for (int j = 2; j < Math.sqrt(i) + 1; j++) {
                    if (i % j == 0) {
                        numberIsNotPrime = true;
                        break;
                    }
                }
                if (numberIsNotPrime) digitPrimes.add(i);
            }
        }
        return digitPrimes;
    }
}
