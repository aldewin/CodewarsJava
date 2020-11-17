/**
 * 5 kyu
 * SIMPLE PIG LATIN
 *
 * Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
 *
 * Examples
 * pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
 * pigIt('Hello world !'); // elloHay orldway !
 */

package codewarsKyu5;

public class KataSimplePigLatin {
    public static void main(String[] args) {
        System.out.println(pigIt("ipsos custodescay  ?"));
    }

    public static String pigIt(String str) {
        char[] symbols = str.toCharArray();
        StringBuilder result = new StringBuilder();

        int countLength = 0;
        String firstSymbols = "";
        for (int i = 0; i < symbols.length; i++) {
            char point = symbols[i];

            if (point == ',' || point == '.' || point == '!' || point == '-' || point == '?' || point == ' ') {
                if (i != symbols.length - 1) {
                    result.append(firstSymbols);
                    countLength = 0;
                    firstSymbols = "";
                }
                result.append(point);
            } else if (countLength == 0) {
                firstSymbols = point + "ay";
                countLength++;
            } else {
                result.append(point);
                countLength++;
            }
            if (i == symbols.length - 1 && countLength != 0) result.append(firstSymbols);
        }

        return result.toString();
    }
}
