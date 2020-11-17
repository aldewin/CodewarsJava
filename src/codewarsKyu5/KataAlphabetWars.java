package codewarsKyu5;

import java.util.HashMap;

public class KataAlphabetWars {
    public static void main(String[] args) {
        System.out.println(woLoLoooooo("scdsczbdbsjfdzetpj"));
    }

    public static String woLoLoooooo(String battlefield) {
        char[] fightArray = battlefield.toCharArray();
        int sumLeft = 0;
        int sumRight = 0;

        replacement(fightArray);

        for (char c : fightArray) {
            if (c == 'w') {
                sumLeft += 4;
            } else if (c == 'p') {
                sumLeft += 3;
            } else if (c == 'b') {
                sumLeft += 2;
            } else if (c == 's') {
                sumLeft++;
            } else if (c == 'm') {
                sumRight += 4;
            } else if (c == 'q') {
                sumRight += 3;
            } else if (c == 'd') {
                sumRight += 2;
            } else if (c == 'z') {
                sumRight++;
            }
        }

        if (sumLeft > sumRight) return "Left side wins!";
        else if (sumRight > sumLeft) return "Right side wins!";
        else return "Let's fight again!";
    }

    private static void replacement(char[] fightArray) {
        char[] leftSide = {'w', 'p', 'b', 's'};
        char[] rightSide = {'m', 'q', 'd', 'z'};

        for (int i = 0; i < fightArray.length; i++) {
            if (fightArray[i] == 't' || fightArray[i] == 'j') {
                if (i == 0) {
                    if (fightArray[i] == 't') {
                        for (int j = 0; j < 4; j++) {
                            if (fightArray[i + 1] == rightSide[j])
                                fightArray[i + 1] = leftSide[j];
                        }
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (fightArray[i + 1] == leftSide[j])
                                fightArray[i + 1] = rightSide[j];
                        }
                    }
                } else if (i == fightArray.length - 1) {
                    if (fightArray[i] == 't') {
                        for (int j = 0; j < 4; j++) {
                            if (fightArray[i - 1] == rightSide[j])
                                fightArray[i - 1] = leftSide[j];
                        }
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (fightArray[i - 1] == leftSide[j])
                                fightArray[i - 1] = rightSide[j];
                        }
                    }
                } else {
                    if (fightArray[i] == 't') {
                        for (int j = 0; j < 4; j++) {
                            if (fightArray[i - 1] == rightSide[j])
                                fightArray[i - 1] = leftSide[j];
                            if (fightArray[i + 1] == rightSide[j])
                                fightArray[i + 1] = leftSide[j];
                        }
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (fightArray[i - 1] == leftSide[j])
                                fightArray[i - 1] = rightSide[j];
                            if (fightArray[i + 1] == leftSide[j])
                                fightArray[i + 1] = rightSide[j];
                        }
                    }
                }

            }

        }
    }
}