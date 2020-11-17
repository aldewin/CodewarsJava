/**
 * GIVE ME A DIAMOND
 * <p>
 * Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string fro
 * Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string from James. Since James doesn't know how to make this happen, he needs your help.
 * <p>
 * Task
 * You need to return a string that looks like a diamond shape when printed on the screen, using asterisk (*) characters. Trailing spaces should be removed, and every line must be terminated with a newline character (\n).
 * <p>
 * Return null/nil/None/... if the input is an even number or negative, as it is not possible to print a diamond of even or negative size.
 * <p>
 * Examples
 * A size 3 diamond:
 * <p>
 * *
 * ***
 * *
 * ...which would appear as a string of " *\n***\n *\n"
 * <p>
 * A size 5 diamond:
 * <p>
 * *
 * ***
 * *****
 * ***
 * *
 * ...that is: " *\n ***\n*****\n ***\n *\n"
 */


package codewarsKyu6;

public class KataGiveMeADiamond {
    public static void main(String[] args) {
        System.out.println(printDiamond(5));
    }

    public static String printDiamond(int n) {
        if (n % 2 == 0 || n < 0) return null;

        boolean checkDown = false;
        int count = 1;
        int countSpace = n / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < countSpace; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < count; j++) {
                sb.append("*");
            }
            if (count < n && !checkDown) {
                count += 2;
                countSpace--;
            } else {
                countSpace++;
                count -= 2;
                checkDown = true;
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
