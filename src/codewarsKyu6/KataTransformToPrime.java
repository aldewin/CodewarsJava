package codewarsKyu6;

public class KataTransformToPrime {
    public static void main(String[] args) {
        System.out.println(minimumNumber(new int[]{2,12,8,4,6}));
    }

    public static int minimumNumber(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        for (int i = sum; i < sum + 15; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) return i - sum;
        }
        return 0;
    }
}
