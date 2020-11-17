package codewarsKyu5;

public class KataCommonDenominators {
    public static void main(String[] args) {
        long[][] lst = new long[][] { {1, 2}, {1, 3}, {10, 40} };
        System.out.println(convertFrac(lst));
    }

    public static String convertFrac(long[][] lst) {
        for (int i = 0; i < lst.length; i++) {
            lst[i] = fractionalSimplification(lst[i]);
        }

        long newDenominator = gcd(lst);

        StringBuilder result = new StringBuilder();
        for (long[] longs : lst) {
            result.append("(").append(newDenominator / longs[1]).append(",").append(newDenominator).append(")");
        }

        return result.toString();
    }

    private static long[] fractionalSimplification(long[] fraction) {
        long numerator = fraction[0];
        long denominator = fraction[1];

        for (long i = numerator; i > 1; i--) {
            long balanceNum = numerator % i;
            long balanceDen = denominator % 10;

            if (balanceNum == 0 && balanceDen == 0)
                return new long[] {numerator / i, denominator / i};
        }

        return fraction;
    }

    private static long maxDenominator(long[][] fractions) {
        long max = 1;
        for (int i = 0; i < fractions.length; i++) {
            max *= fractions[i][1];
        }
        return max;
    }

    private static long maxDenominatorOfFraction(long[][] fractions) {
        long max = 0;
        for (int i = 0; i < fractions.length; i++) {
            if (fractions[i][1] > max)
                max = fractions[i][1];
        }
        return max;
    }

    private static long gcd(long[][] fractions) {
        long maxDenominator = maxDenominator(fractions);
        long minDenominator = maxDenominatorOfFraction(fractions);

        for (long denominator = minDenominator; denominator < maxDenominator; denominator++) {
            boolean isDenominator = true;
            for (long[] fraction : fractions) {
                if (denominator % fraction[1] != 0) {
                    isDenominator = false;
                    break;
                }
            }

            if (isDenominator)
                return denominator;
        }

        return maxDenominator;
    }
}
