/**
 * WHAT'S IN A NAME?
 * <p>
 * ..Or rather, what's a name in? For us, a particular string is where we are looking for a name.
 * Task
 * Test whether or not the string contains all of the letters which spell a given name, in order.
 * <p>
 * The format
 * A function passing two strings, searching for one (the name) within the other. ``function nameInStr(str, name){ return true || false }``
 * Examples
 * nameInStr("Across the rivers", "chris") --> true
 * ^      ^  ^^   ^
 * c      h  ri   s
 * <p>
 * Contains all of the letters in "chris", in order.
 * nameInStr("Next to a lake", "chris") --> false
 * <p>
 * Contains none of the letters in "chris".
 * nameInStr("Under a sea", "chris") --> false
 * ^   ^
 * r   s
 * <p>
 * Contains only some of the letters in "chris".
 * nameInStr("A crew that boards the ship", "chris") --> false
 * cr    h              s i
 * cr                h  s i
 * c     h      r       s i
 * ...
 * <p>
 * Contains all of the letters in "chris", but not in order.
 * nameInStr("A live son", "Allison") --> false
 * ^ ^^   ^^^
 * A li   son
 * <p>
 * Contains all of the correct letters in "Allison", in order,
 * but not enough of all of them (missing an 'l').
 * Note: testing will not be case-sensitive.
 */

package codewarsKyu6;

public class KataWhatsInAName {
    public static void main(String[] args) {
        System.out.println(nameInStr("A live son", "Allison"));
    }

    public static boolean nameInStr(String str, String name) {
        int index = 0;
        int checkNameEnd = 0;
        for (int i = 0; i < name.length(); i++) {
            char charOfName = name.charAt(i);
            for (int j = index; j < str.length(); j++) {
                if (charOfName == str.charAt(j)) {
                    checkNameEnd++;
                    index = ++j;
                    break;
                }
            }
            if (checkNameEnd == name.length()) return true;
        }
        return false;
    }
}
