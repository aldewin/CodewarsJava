/**
 * YOUR ORDER, PLEASE
 * <p>
 * Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.
 * <p>
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 * <p>
 * If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.
 * <p>
 * Examples
 * "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
 * "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
 * ""  -->  ""
 */

package codewarsKyu6;

public class KataYourOrder {
    public static void main(String[] args) {
        System.out.println(order("Empty input should return empty string"));
    }

    public static String order(String words) {
        String[] string = words.split(" ");
        String[] sentence = new String[string.length];
        for (int i = 0; i < string.length; i++) {
            for (int j = 0; j < string[i].length(); j++) {
                char charOfInt = string[i].charAt(j);
                if (charOfInt == '1' || charOfInt == '2' || charOfInt == '3' || charOfInt == '4' ||
                        charOfInt == '5' || charOfInt == '6' || charOfInt == '7' ||
                        charOfInt == '8' || charOfInt == '9') {
                    sentence[Integer.parseInt(String.valueOf(charOfInt)) - 1] = string[i];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length; i++) {
            if (sentence[i] == null) return "";

            sb.append(sentence[i]);
            if (i != sentence.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
