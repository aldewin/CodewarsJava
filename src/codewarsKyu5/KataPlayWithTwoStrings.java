package codewarsKyu5;

public class KataPlayWithTwoStrings {
    public static void main(String[] args) {
        System.out.println(workOnStrings("abc","cde"));
    }

    public static String workOnStrings(String a, String b) {
        return stringUpperOrLower(a, b) + stringUpperOrLower(b ,a);
    }

    private static String stringUpperOrLower(String a, String b) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            int count = 0;
            char symbol = a.charAt(i);
            for (int j = 0; j < b.length(); j++) {
                if (Character.toLowerCase(symbol) == Character.toLowerCase(b.charAt(j)))
                    count++;
            }

            if (count % 2 != 0) {
                if (symbol == Character.toLowerCase(symbol))
                    symbol = Character.toUpperCase(symbol);
                else
                    symbol = Character.toLowerCase(symbol);
            }

            newString.append(symbol);
        }
        return newString.toString();
    }
}

// true: abcDeFGtrzWDEFGgGFhjkWqE
// my:   abcDeFGtrzWDEFGgGFhjkWqE
