/**
 * 5 kyu DIOPHANTINE EQUATION
 *
 * 4508288% of 357297 of 2,058g964
 * Java
 * TRAIN AGAINNEXT KATA
 * Details
 * Solutions
 * Forks (3)
 * Discourse (147)
 * Collect|
 * In mathematics, a Diophantine equation is a polynomial equation, usually with two or more unknowns, such that only the integer solutions are sought or studied.
 *
 * In this kata we want to find all integers x, y (x >= 0, y >= 0) solutions of a diophantine equation of the form:
 *
 * x2 - 4 * y2 = n
 * (where the unknowns are x and y, and n is a given positive number) in decreasing order of the positive xi.
 *
 * If there is no solution return [] or "[]" or "". (See "RUN SAMPLE TESTS" for examples of returns).
 *
 * Examples:
 * solEquaStr(90005) --> "[[45003, 22501], [9003, 4499], [981, 467], [309, 37]]"
 * solEquaStr(90002) --> "[]"
 * Hint:
 * x2 - 4 * y2 = (x - 2*y) * (x + 2*y)
 */

package codewarsKyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KataDiophantineEquation {
    public static void main(String[] args) {
        System.out.println(solEquaStr(16));
    }

    public static String solEquaStr(int n) {
        List<String> roots = new ArrayList<>();

        for (long numLeft = 1; numLeft < Math.sqrt(n) + 1; numLeft++) {
            if (n % numLeft == 0) {
                long[] elements = new long[2];

                long numRight = n / numLeft;
                long y = -(numLeft - numRight) / 4;
                long x = numLeft + y;

                if (x >= 0 && y >= 0 && x + 2 * y == numRight && x - 2 * y == numLeft) {
                    elements[0] = x;
                    elements[1] = y;
                    roots.add(Arrays.toString(elements));
                }
            }
        }
        return String.valueOf(roots);
    }
}
