package codewarsKyu4;

import java.util.ArrayList;
import java.util.List;

public class KataTimeFomatter {
    public static void main(String[] args) {
        System.out.println(formatDuration(1));
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0)
            return "now";

        int minuteSecond = 60;
        int hourSecond = minuteSecond * 60;
        int daySecond = hourSecond * 24;
        int yearSecond = daySecond * 365;

        int[] timeSecond = {yearSecond, daySecond, hourSecond, minuteSecond, 1};
        String[] components = {"year", "day", "hour", "minute", "second"};

        List<String> timeString = new ArrayList<>();
        for (int i = 0; i < components.length; i++) {
            if (seconds >= timeSecond[i]) {
                int time = seconds / timeSecond[i];
                timeString.add(pluralTime(time, components[i]));
                seconds -= time * timeSecond[i];
            }
        }

        StringBuilder result = new StringBuilder();
        int lengthList = timeString.size();
        for (int i = 0; i < lengthList; i++) {
            result.append(timeString.get(i));
            if (lengthList > 1) {
                if (i != lengthList - 2)
                    result.append(", ");
                else {
                    result.append(" and ");
                    return result.append(timeString.get(lengthList - 1)).toString();
                }
            }
        }
        return result.toString();
    }

    private static String pluralTime(int num, String time) {
        if (num == 1)
            return String.format("%d %s", num, time);
        return String.format("%d %ss", num, time);
    }
}
