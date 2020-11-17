package codewarsKyu6;

import java.util.Arrays;

public class KataEnglishBeggars {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(beggars(new int[]{1, 2, 3, 4, 5}, 0)));
    }

    public static int[] beggars(int[] values, int n) {
        if (n == 0) return new int[] {};

        int[] sumValues = new int[n];
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (count == n) count = 0;
            sumValues[count] += values[i];
            count++;
        }
        return sumValues;
    }
}
