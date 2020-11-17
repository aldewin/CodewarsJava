/**
 * 5 kyu
 * GREED IS GOOD
 *
 * Greed is a dice game played with five six-sided dice. Your mission, should you choose to accept it, is to score a
 * throw according to these rules. You will always be given an array with five six-sided dice values.
 *
 * Three 1's => 1000 points
 * Three 6's => 600 points
 * Three 5's => 500 points
 * Three 4's => 400 points
 * Three 3's => 300 points
 * Three 2's => 200 points
 * One 1 => 100 points
 * One 5 => 50 point
 * A single die can only be counted once in each roll. For example, a "5" can only count as part of a triplet
 * (contributing to the 500 points) or as a single 50 points, but not both in the same roll.
 *
 * Example scoring
 *
 * Throw Score
 * —-----— —--------------—
 * 5 1 3 4 1 50 + 2 * 100 = 250
 * 1 1 1 3 1 1000 + 100 = 1100
 * 2 4 4 5 4 400 + 50 = 450
 * In some languages, it is possible to mutate the input to the function. This is something that you should never do.
 * If you mutate the input, you will not be able to pass all the tests.
 */

package codewarsKyu5;

public class KataGreedIsGood {
    public static void main(String[] args) {
        System.out.println(greedy(new int[] {1, 1, 1, 3, 1}));
    }

    public static int greedy(int[] dice) {
        int[] count = new int[6];
        for (int die : dice) {
            if (die != 1) {
                count[die - 1]++;
            }
        }

        return sumNumbers(count) + sumOne(dice) + count[4] * 50;
    }

    private static int sumNumbers(int[] count) {
        int sum = 0;
        for (int i = 1; i < count.length; i++)
            while (count[i] >= 3) {
                sum += (i + 1) * 100;
                count[i] -= 3;
            }
        return sum;
    }

    private static int sumOne(int[] dice) {
        int sum = 0;
        int count = 0;
        for (int die : dice) {
            if (die == 1) {
                count++;
                if (count == 3) {
                    sum += 1000;
                    count -= 3;
                }
            }
        }
        return sum + count * 100;
    }
}
