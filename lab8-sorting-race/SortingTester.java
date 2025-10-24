import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};
        System.out.println("--- The Sorting Race ---");
        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            int[] randomArray = generateRandomArray(n);
            runAndTimeAllSorts(randomArray, "Average Case");
            int[] sortedArray = generateSortedArray(n);
            runAndTimeAllSorts(sortedArray, "Best Case");
            int[] reverseArray = generateReverseSortedArray(n);
            runAndTimeAllSorts(reverseArray, "Worst Case");
        }
    }

    public static void runAndTimeAllSorts(int[] originalArray, String caseType) {
        System.out.println("\n" + caseType + ":");
        int[] arr;
        arr = originalArray.clone();
        long start = System.nanoTime();
        SortingAlgorithms.selectionSort(arr);
        long end = System.nanoTime();
        System.out.println("Selection Sort: " + (end - start) / 1e6 + " ms");
        arr = originalArray.clone();
        start = System.nanoTime();
        SortingAlgorithms.insertionSort(arr);
        end = System.nanoTime();
        System.out.println("Insertion Sort: " + (end - start) / 1e6 + " ms");
        arr = originalArray.clone();
        start = System.nanoTime();
        SortingAlgorithms.mergeSort(arr);
        end = System.nanoTime();
        System.out.println("Merge Sort: " + (end - start) / 1e6 + " ms");
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt();
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = size - i;
        return arr;
    }
}
