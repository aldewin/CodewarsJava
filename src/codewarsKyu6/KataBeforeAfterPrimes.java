/**
 * 6 kyu
 * SURROUNDING PRIMES FOR A VALUE
 *
 * We need a function prime_bef_aft() that gives the largest prime below a certain given value n,
 *
 * befPrime or bef_prime (depending on the language),
 *
 * and the smallest prime larger than this value,
 *
 * aftPrime/aft_prime (depending on the language).
 *
 * The result should be output in a list like the following:
 *
 * prime_bef_aft(n) == [befPrime, aftPrime]
 * If n is a prime number it will give two primes, n will not be included in the result.
 *
 * Let's see some cases:
 *
 * prime_bef_aft(100) == [97, 101]
 *
 * prime_bef_aft(97) == [89, 101]
 *
 * prime_bef_aft(101) == [97, 103]
 * Range for the random tests: 1000 <= n <= 200000
 *
 * (The extreme and special case n = 2 will not be considered for the tests. Thanks Blind4Basics)
 */

package codewarsKyu6;

import java.util.Arrays;

public class KataBeforeAfterPrimes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(primeBefAft(97)));
    }

    public static long[] primeBefAft(long num) {
        long[] primes = new long[2];

        for (long i = num - 1; i > 0; i--) {
            boolean isMinPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isMinPrime = false;
                    break;
                }
            }
            if (isMinPrime) {
                primes[0] = i;
                break;
            }
        }

        for (long i = num + 1; i < num + 100; i++) {
            boolean isMaxPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isMaxPrime = false;
                    break;
                }
            }
            if (isMaxPrime) {
                primes[1] = i;
                break;
            }
        }
        return primes;
    }
}
