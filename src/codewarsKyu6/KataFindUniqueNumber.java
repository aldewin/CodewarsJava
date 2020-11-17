/**
 * There is an array with some numbers. All numbers are equal except for one. Try to find it!
 * <p>
 * Kata.findUnique(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
 * Kata.findUnique(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
 * It’s guaranteed that array contains at least 3 numbers.
 * <p>
 * The tests contain some very huge arrays, so think about performance.
 * <p>
 * This is the first kata in series:
 * <p>
 * 1) Find the unique number (this kata)
 * 2) Find the unique string
 * 3) Find The Unique
 */

package codewarsKyu6;


import java.util.HashMap;
import java.util.Map;

public class KataFindUniqueNumber {
    public static void main(String[] args) {
        System.out.println(findUnique(new double[] {1, 1, 1, 2, 1, 1}));
    }

    public static double findUnique(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (i == 0 && arr[i] != arr[i +1]) {
                if (arr[i + 1] != arr[i+2]) return arr[i + 1];
                else return arr[i];
            }
            if (arr[i] != arr[i + 1]) return arr[i + 1];
        }
        return 0;
    }
}
