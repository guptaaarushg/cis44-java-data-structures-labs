public class SearchComparison {

    /**
     * Lab 1a: Iterative Linear Search (with comparison counter)
     * Searches for 'key' in the array 'arr' one element at a time.
     * @param arr The array to search (can be unsorted).
     * @param key The value to find.
     * @return The index of the key if found, otherwise -1.
     */
    public static int linearSearch(int[] arr, int key) {
        int comparisonCounter = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisonCounter++; // one comparison: arr[i] == key
            if (arr[i] == key) {
                System.out.println("Linear comparisons: " + comparisonCounter);
                return i;
            }
        }

        System.out.println("Linear comparisons: " + comparisonCounter);
        return -1;
    }

    /**
     * Lab 1b: Iterative Binary Search (with comparison counter)
     * Searches for 'key' in a sorted array 'arr' using the divide-and-conquer method.
     * @param arr The array to search (MUST be sorted).
     * @param key The value to find.
     * @return The index of the key if found, otherwise -1.
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int comparisonCounter = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisonCounter++; // one comparison: arr[mid] == key

            if (arr[mid] == key) {
                System.out.println("Binary comparisons: " + comparisonCounter);
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Binary comparisons: " + comparisonCounter);
        return -1;
    }

    public static void main(String[] args) {
        int[] unsortedData = {22, 8, 12, 1, 9, 30, 4, 15};
        int[] sortedData =   {1, 4, 8, 9, 12, 15, 22, 30};

        System.out.println("--- Lab 1: Search Algorithm Implementation ---");

        System.out.println("Linear Search (Unsorted):");
        System.out.println("Find 9: Index " + linearSearch(unsortedData, 9)); // Expected: 4
        System.out.println("Find 3: Index " + linearSearch(unsortedData, 3)); // Expected: -1

        System.out.println("\nBinary Search (Sorted):");
        System.out.println("Find 9: Index " + binarySearch(sortedData, 9));   // Expected: 3
        System.out.println("Find 3: Index " + binarySearch(sortedData, 3));   // Expected: -1
        System.out.println("Find 30: Index " + binarySearch(sortedData, 30)); // Expected: 7

        System.out.println("\nLinear Search (Sorted, find 30 - worst case):");
        System.out.println("Find 30: Index " + linearSearch(sortedData, 30)); // Expected: 7
    }
}
