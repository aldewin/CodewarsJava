/**
 * MULTI-TAP KEYPAD TEXT ENTRY ON AN OLD MOBILE PHONE
 *
 * Prior to having fancy iPhones, teenagers would wear out their thumbs sending SMS messages on candybar-shaped feature
 * phones with 3x4 numeric keypads.
 *
 * ------- ------- -------
 * |     | | ABC | | DEF |
 * |  1  | |  2  | |  3  |
 * ------- ------- -------
 * ------- ------- -------
 * | GHI | | JKL | | MNO |
 * |  4  | |  5  | |  6  |
 * ------- ------- -------
 * ------- ------- -------
 * |PQRS | | TUV | | WXYZ|
 * |  7  | |  8  | |  9  |
 * ------- ------- -------
 * ------- ------- -------
 * |     | |space| |     |
 * |  *  | |  0  | |  #  |
 * ------- ------- -------
 * Prior to the development of T9 (predictive text entry) systems, the method to type words was called "multi-tap" and
 * involved pressing a button repeatedly to cycle through the possible values.
 *
 * For example, to type a letter "R" you would press the 7 key three times (as the screen display for the current
 * character cycles through P->Q->R->S->7). A character is "locked in" once the user presses a different key or pauses
 * for a short period of time (thus, no extra button presses are required beyond what is needed for each letter
 * individually). The zero key handles spaces, with one press of the key producing a space and two presses producing a
 * zero.
 *
 * In order to send the message "WHERE DO U WANT 2 MEET L8R" a teen would have to actually do 47 button presses. No
 * wonder they abbreviated.
 *
 * For this assignment, write a module that can calculate the amount of button presses required for any phrase. Punctuation can be ignored for this exercise. Likewise, you can assume the phone doesn't distinguish between upper/lowercase characters (but you should allow your module to accept input in either for convenience).
 *
 * Hint: While it wouldn't take too long to hard code the amount of keypresses for all 26 letters by hand, try to avoid doing so! (Imagine you work at a phone manufacturer who might be testing out different keyboard layouts, and you want to be able to test new ones rapidly.)
 */

package codewarsKyu6;

public class KataKeypad {
    public static void main(String[] args) {
        System.out.println(passes("UXwmMsWsKGsr#xu"));
    }

    public static int passes(String phrase) {
        phrase = phrase.toUpperCase();
        int sumChar = 0;
        for (int i = 0; i < phrase.length(); i++) {
            char charOfPhrase = phrase.charAt(i);
            if (charOfPhrase == '7' || charOfPhrase == '9') {
                sumChar += 5;
            } else if (charOfPhrase == 'S' || charOfPhrase == 'Z' || charOfPhrase == '2' || charOfPhrase == '3' ||
                    charOfPhrase == '4' || charOfPhrase == '5' || charOfPhrase == '6' || charOfPhrase == '8') {
                sumChar += 4;
            } else if (charOfPhrase == 'C' || charOfPhrase == 'F' || charOfPhrase == 'I' || charOfPhrase == 'L' ||
                    charOfPhrase == 'O' || charOfPhrase == 'R' || charOfPhrase == 'V' || charOfPhrase == 'Y') {
                sumChar += 3;
            } else if (charOfPhrase == 'B' || charOfPhrase == 'E' || charOfPhrase == 'H' || charOfPhrase == 'K' ||
                    charOfPhrase == 'N' || charOfPhrase == 'Q' || charOfPhrase == 'U' || charOfPhrase == 'X' || charOfPhrase == '0') {
                sumChar += 2;
            } else if (charOfPhrase == '*' || charOfPhrase == '1' || charOfPhrase == ' ' || charOfPhrase == '#' ||
                    charOfPhrase == 'A' || charOfPhrase == 'D' || charOfPhrase == 'G' || charOfPhrase == 'J' || charOfPhrase == 'M' ||
                    charOfPhrase == 'P' || charOfPhrase == 'T' || charOfPhrase == 'W') {
                sumChar++;
            }
        }
        return sumChar;
    }
}
