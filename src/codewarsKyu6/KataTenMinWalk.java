package codewarsKyu6;

public class KataTenMinWalk {
    public static void main(String[] args) {
        System.out.println(isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
    }

    public static boolean isValid(char[] walk) {
        if (walk.length != 10) return false;

        for (int i = 0; i < walk.length; i++) {
            for (int j = i + 1; j < walk.length; j++) {
                if ((walk[i] == 'n' && walk[j] == 's') || (walk[i] == 's' && walk[j] == 'n') ||
                        (walk[i] == 'w' && walk[j] == 'e') || (walk[i] == 'e' && walk[j] == 'w')) {
                    walk[i] = 0;
                    walk[j] = 0;
                    break;
                }
            }
        }

        for (char c : walk) {
            if (c != 0) return false;
        }
        return true;
    }
}
