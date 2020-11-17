package codewarsKyu7;

public class KataAngelSum {
    public static void main(String[] args) {
        System.out.println(sumOfAngels(4));
    }

    public static int sumOfAngels(int n) {
        return 180 * (n - 2);
    }
}
