public class MaxSubarraySolver {

    public static int bruteForceMaxSum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;


        // Outer loop runs n times, inner loop runs up to n times, meaning that the total ~ n(n+1)/2 additions, so time complexity is O(n^2)
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    public static int kadanesAlgorithmMaxSum(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];


        // Each element is visited once, and total operations proportional to n so time complexity is O(n)
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
