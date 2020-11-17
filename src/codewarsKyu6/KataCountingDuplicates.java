package codewarsKyu6;

import java.util.ArrayList;

public class KataCountingDuplicates {
    public static void main(String[] args) {
        System.out.println(duplicateCount("indivisibility"));
    }

    public static int duplicateCount(String text) {
        ArrayList<Character> symbols = new ArrayList<>();
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            symbols.add(text.charAt(i));
        }

        int result = 0;
        for (int i = 0; i < symbols.size(); i++) {
            int count = 0;
            for (int j = i + 1; j < symbols.size(); j++) {
                if (symbols.get(i) == symbols.get(j)) {
                    count++;
                    char delSymbol = symbols.get(i);
                    for (int k = i; k < symbols.size(); k++) {
                        if (delSymbol == symbols.get(k)) symbols.remove(k);
                    }
                }
            }
            if (count > 0) result++;
        }
        return result;
    }
}
