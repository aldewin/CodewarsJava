/**
 * Integer triangles
 *
 * https://www.codewars.com/kata/55db7b239a11ac71d600009d/train/java
 */

package codewarsKyu5;

public class KataIntTriangles {
    public static void main(String[] args) {
        System.out.println(giveTriang(30));
    }

    public static int giveTriang(int per) {
        // a² + ab + b² = c²

        int count = 0;
        for (int a = 1; a < per; a++) {
            for (int b = a + 1; a + b < per; b++) {
                int cSquared = a * a + a * b + b * b;
                int c = (int) Math.sqrt(cSquared);

                if (c * c == cSquared && a + b + c <= per)
                    count++;
            }
        }

        return count;
    }
}
