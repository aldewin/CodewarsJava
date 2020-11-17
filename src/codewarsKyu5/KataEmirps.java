/**
 * Emirps
 *
 * https://www.codewars.com/kata/55de8eabd9bef5205e0000ba/train/java
 */

package codewarsKyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KataEmirps {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findEmirp(200)));
    }

    public static long[] findEmirp(long n) {
        List<Long> emirp = new ArrayList<>();
        int sum = 0;
        for (long i = 13; i <= n; i += 2) {
            boolean isPrime = checkPrime(i);
            if (isPrime) {
                long reverseNumber = Integer.parseInt(String.valueOf(new StringBuffer(String.valueOf(i)).reverse()));
                if (reverseNumber <= i || reverseNumber % 2 == 0)
                    continue;

                if (checkPrime(reverseNumber)) {
                    emirp.add(i);
                    sum += i;

                    if (reverseNumber <= n) {
                        emirp.add(reverseNumber);
                        sum += reverseNumber;
                    }
                }
            }
        }
        Collections.sort(emirp);
        return new long[]{emirp.size(), emirp.get(emirp.size() - 1), sum};
    }

    private static boolean checkPrime(long number) {
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
