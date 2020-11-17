/**
 * 6 kyu
 * CLOCKY MC CLOCK-FACE
 *
 * Story
 * Due to lack of maintenance the minute-hand has fallen off Town Hall clock face.
 *
 * And because the local council has lost most of our tax money to a Nigerian email scam there are no funds to fix the clock properly.
 *
 * Instead, they are asking for volunteer programmers to write some code that tell the time by only looking at the remaining hour-hand!
 *
 * What a bunch of cheapskates!
 *
 * Can you do it?
 *
 * Kata
 * Given the angle (in degrees) of the hour-hand, return the time in HH:MM format. Round down to the nearest minute.
 *
 * Examples
 * 12:00 = 0 degrees
 * 03:00 = 90 degrees
 * 06:00 = 180 degrees
 * 09:00 = 270 degrees
 * 12:00 = 360 degrees
 * Notes
 * 0 <= angle <= 360
 */

package codewarsKyu6;

public class KataDinglemouse {
    public static void main(String[] args) {
        System.out.println(whatTimeIsIt(180));
    }

    public static String whatTimeIsIt(final double angle) {
        int hour = 0;
        int minutes = 0;
        double angleInt = 0;
        if (angle % 1 != 0) angleInt = angle * 2 - 1;
        else angleInt = angle * 2;
        for (int i = 0; i < angleInt; i++) {
            minutes += 1;
            if (minutes > 59) {
                hour++;
                minutes = minutes - 60;
            }
        }

        if (hour == 0) hour = 12;

        StringBuilder time = new StringBuilder();
        if (hour < 10) time.append(0);
        time.append(hour).append(":");
        if (minutes < 10) time.append(0);
        return time.append(minutes).toString();
    }
}
