/**
 * WHERE IS MY PARENT!?(СRY)
 * <p>
 * Mothers arranged a dance party for the children in school. At that party, there are only mothers and their children.
 * All are having great fun on the dance floor when suddenly all the lights went out. It's a dark night and no one can
 * see each other. But you were flying nearby and you can see in the dark and have ability to teleport people anywhere
 * you want.
 * <p>
 * Legend:
 * -Uppercase letters stands for mothers, lowercase stand for their children, i.e. "A" mother's children are "aaaa".
 * -Function input: String contains only letters, uppercase letters are unique.
 * Task:
 * Place all people in alphabetical order where Mothers are followed by their children, i.e. "aAbaBb" => "AaaBbb".
 */

package codewarsKyu6;

import java.util.HashMap;
import java.util.Map;

public class KataWhereIsMyParent {
    public static void main(String[] args) {
        System.out.println(findChildren("CbcBcbaA"));
    }

    public static String findChildren(final String text) {
        Map<Character, Double> dictionary = new HashMap<>();
        dictionary.put('a', 1.5);
        dictionary.put('b', 2.5);
        dictionary.put('c', 3.5);
        dictionary.put('d', 4.5);
        dictionary.put('e', 5.5);
        dictionary.put('f', 6.5);
        dictionary.put('g', 7.5);
        dictionary.put('h', 8.5);
        dictionary.put('i', 9.5);
        dictionary.put('j', 10.5);
        dictionary.put('k', 11.5);
        dictionary.put('l', 12.5);
        dictionary.put('m', 13.5);
        dictionary.put('n', 14.5);
        dictionary.put('o', 15.5);
        dictionary.put('p', 16.5);
        dictionary.put('q', 17.5);
        dictionary.put('r', 18.5);
        dictionary.put('s', 19.5);
        dictionary.put('t', 20.5);
        dictionary.put('u', 21.5);
        dictionary.put('v', 22.5);
        dictionary.put('w', 23.5);
        dictionary.put('x', 24.5);
        dictionary.put('y', 25.5);
        dictionary.put('z', 26.5);
        dictionary.put('A', (double) 1);
        dictionary.put('B', (double) 2);
        dictionary.put('C', (double) 3);
        dictionary.put('D', (double) 4);
        dictionary.put('E', (double) 5);
        dictionary.put('F', (double) 6);
        dictionary.put('G', (double) 7);
        dictionary.put('H', (double) 8);
        dictionary.put('I', (double) 9);
        dictionary.put('J', (double) 10);
        dictionary.put('K', (double) 11);
        dictionary.put('L', (double) 12);
        dictionary.put('M', (double) 13);
        dictionary.put('N', (double) 14);
        dictionary.put('O', (double) 15);
        dictionary.put('P', (double) 16);
        dictionary.put('Q', (double) 17);
        dictionary.put('R', (double) 18);
        dictionary.put('S', (double) 19);
        dictionary.put('T', (double) 20);
        dictionary.put('U', (double) 21);
        dictionary.put('V', (double) 22);
        dictionary.put('W', (double) 23);
        dictionary.put('X', (double) 24);
        dictionary.put('Y', (double) 25);
        dictionary.put('Z', (double) 26);

        char[] mas = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            mas[i] = text.charAt(i);
        }

        char c;
        for (int i = 0; i < mas.length - 1; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                if (dictionary.get(mas[i]) > dictionary.get(mas[j])) {
                    c = mas[i];
                    mas[i] = mas[j];
                    mas[j] = c;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char symbol : mas) {
            sb.append(symbol);
        }

        return sb.toString();
    }
}