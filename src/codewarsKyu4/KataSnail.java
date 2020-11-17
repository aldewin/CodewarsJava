/**
 * 5 kyu SNAIL
 *
 * Snail Sort
 * Given an n x n array, return the array elements arranged from outermost elements to the middle element,
 * traveling clockwise.
 *
 * array = [[1,2,3],
 *          [4,5,6],
 *          [7,8,9]]
 * snail(array) #=> [1,2,3,6,9,8,7,4,5]
 * For better understanding, please follow the numbers of the next array consecutively:
 *
 * array = [[1,2,3],
 *          [8,9,4],
 *          [7,6,5]]
 * snail(array) #=> [1,2,3,4,5,6,7,8,9]
 * This image will illustrate things more clearly:
 *
 *
 * NOTE: The idea is not sort the elements from the lowest value to the highest; the idea is to traverse the 2-d array
 * in a clockwise snailshell pattern.
 *
 * NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].
 */

package codewarsKyu4;

import java.util.Arrays;

public class KataSnail {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(snail(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public static int[] snail(int[][] array) {
        if (array[0].length == 0)
            return new int[0];

        int lengthResult = array.length;
        int[] result = new int[lengthResult * lengthResult];

        int countX = 1;
        int countY = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < result.length; ++i) {
            result[i] = array[y][x];
            array[y][x] = -1;
            x += countX;
            y += countY;

            if ((x < 0 || x >= lengthResult || array[y][x] == -1) && countX != 0) {
                x -= countX;
                y += countX;

                countY = countX;
                countX = 0;
            } else if ((y >= lengthResult || y < 0 || array[y][x] == -1) && countY != 0) {
                y -= countY;
                x -= countY;

                countX = -countY;
                countY = 0;
            }
        }
        return result;
    }
}
