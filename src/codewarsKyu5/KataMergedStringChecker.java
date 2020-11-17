/**
 * At a job interview, you are challenged to write an algorithm to check if a given string, s, can be formed from two other strings, part1 and part2.
 *
 * The restriction is that the characters in part1 and part2 should be in the same order as in s.
 *
 * The interviewer gives you the following example and tells you to figure out the rest from the given test cases.
 *
 * For example:
 *
 * 'codewars' is a merge from 'cdw' and 'oears':
 *
 * s: c o d e w a r s = codewars
 * part1: c d w = cdw
 * part2: o e a r s = oears
 */

package codewarsKyu5;

public class KataMergedStringChecker {
    public static void main(String[] args) {
        System.out.println(isMerge("codewars", "code", "wars"));
    }

    public static boolean isMerge(String s, String part1, String part2) {
        if (s.length() == 0) {
            return part1.length() == 0 && part2.length() == 0;
        } else {
            boolean checkFirstString = false;
            boolean checkSecondString = false;
            if (part1.length() > 0 && s.charAt(0) == part1.charAt(0)) {
                checkFirstString = isMerge(s.substring(1), part1.substring(1), part2);
            }
            if (part2.length() > 0 && s.charAt(0) == part2.charAt(0)) {
                checkSecondString = isMerge(s.substring(1), part1, part2.substring(1));
            }
            return checkFirstString || checkSecondString;
        }
    }
}
