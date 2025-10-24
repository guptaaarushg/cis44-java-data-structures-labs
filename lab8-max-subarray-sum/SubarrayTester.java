import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            int[] arr = generateRandomArrayWithNegatives(n);

            if (n <= 10000) {
                long startBF = System.nanoTime();
                int maxBF = MaxSubarraySolver.bruteForceMaxSum(arr);
                long endBF = System.nanoTime();
                System.out.println("Brute-force max sum: " + maxBF + " | Time: " + (endBF - startBF) / 1e6 + " ms");
            } else {
                System.out.println("Brute-force skipped for n > 10000");
            }

            long startKadane = System.nanoTime();
            int maxKadane = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            long endKadane = System.nanoTime();
            System.out.println("Kadane's max sum: " + maxKadane + " | Time: " + (endKadane - startKadane) / 1e6 + " ms");
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(201) - 100;
        }
        return arr;
    }
}
