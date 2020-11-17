package codewarsKyu5;

import java.util.Arrays;

public class KataFindTheSmallest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallest(261235)));
    }

    public static long[] smallest(long n) {
        String str = String.valueOf(n);
        int min = 10;
        int digit;
        int numEnd = 0;
        for (int i = 1; i < str.length(); i++) {
            digit = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (digit < min) {
                min = digit;
                numEnd = i;
            }
        }
        int numBegin = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            digit = Integer.parseInt(String.valueOf(chars[i]));
            if (min < digit) {
                char variable = str.charAt(i);
                chars[i] = Character.highSurrogate(min);
                chars[numEnd] = variable;
                numBegin = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return new long[] {Long.parseLong(String.valueOf(sb)), numBegin, numEnd};
    }
}
