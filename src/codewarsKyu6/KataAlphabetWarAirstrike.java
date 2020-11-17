/**
 * ALPHABET WAR - AIRSTRIKE - LETTERS MASSACRE
 * <p>
 * There is a war and nobody knows - the alphabet war! There are two groups of hostile letters. The tension between left side letters and right side letters was too high and the war began. The letters called airstrike to help them in war - dashes and dots are spreaded everywhere on the battlefield.
 * <p>
 * Task
 * Write a function that accepts fight string consists of only small letters and * which means a bomb drop place. Return who wins the fight after bombs are exploded. When the left side wins return Left side wins!, when the right side wins return Right side wins!, in other case return Let's fight again!.
 * <p>
 * The left side letters and their power:
 * <p>
 * w - 4
 * p - 3
 * b - 2
 * s - 1
 * The right side letters and their power:
 * <p>
 * m - 4
 * q - 3
 * d - 2
 * z - 1
 * The other letters don't have power and are only victims.
 * The * bombs kills the adjacent letters ( i.e. aa*aa => a___a, **aa** => ______ );
 * <p>
 * Example
 * AlphabetWar("s*zz");           //=> Right side wins!
 * AlphabetWar("*zd*qm*wp*bs*"); //=> Let's fight again!
 * AlphabetWar("zzzz*s*");       //=> Right side wins!
 */

package codewarsKyu6;

public class KataAlphabetWarAirstrike {
    public static void main(String[] args) {
        System.out.println(alphabetWar("****"));
    }

    public static String alphabetWar(String fight) {
        char[] fightAir = new char[fight.length()];


        for (int i = 0; i < fight.length(); i++) {
            fightAir[i] = fight.charAt(i);
        }

        for (int i = 0; i < fightAir.length; i++) {
            if (fightAir[i] == '*') {
                if (i == 0) {
                    if (fightAir[i + 1] != '*') fightAir[i + 1] = 'a';
                } else if (i == fightAir.length - 1) {
                    if (fightAir[i - 1] != '*') fightAir[i - 1] = 'a';
                } else {
                    if (fightAir[i - 1] != '*') fightAir[i - 1] = 'a';
                    if (fightAir[i + 1] != '*') fightAir[i + 1] = 'a';
                }
            }
        }

        int sumLeft = 0;
        int sumRight = 0;
        for (char c : fightAir) {
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
}
