package codewarsKyu5;

public class KataMaximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(sequence((new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})));
    }

    public static int sequence(int[] arr) {
        int sumArray = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                int sum = 0;
                for (int k = j; k >= i; k--) {
                    sum += arr[k];
                }
                if (sum > sumArray) sumArray = sum;
            }
        }
        return sumArray;
    }
}
