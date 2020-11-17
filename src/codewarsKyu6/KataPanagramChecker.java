/**
 * A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence
 * "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is
 * irrelevant).
 * <p>
 * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and
 * punctuation.
 */

package codewarsKyu6;

public class KataPanagramChecker {
    public static void main(String[] args) {
        System.out.println(check("You shall not pass!"));
    }

    public static boolean check(String sentence) {
        sentence = sentence.replaceAll("[ !&,.:;0987654321*+<>{}]", "").toLowerCase();
        char[] alphabet = new char[sentence.length()];

        for (int i = 0; i < sentence.length(); i++) {
            boolean checkAlphabet = false;
            for (int j = 0; j < alphabet.length; j++) {
                if (sentence.charAt(i) == alphabet[j]) {
                    checkAlphabet = true;
                    break;
                }
            }
            if (!checkAlphabet) alphabet[i] = sentence.charAt(i);
        }

        int sum = 0;
        for (char c : alphabet) {
            if (c != 0) sum++;
        }

        if (sum == 26) return true;
        else return false;
    }
}
