import java.util.Arrays;

public class SortingAlgorithms {

    public static void main(String[] args) {
        int[] numbers = {25, -3, 5, 10, 38, 62, 20, -8, 173, 65};

        System.out.println("\nBubble Sort:");
        testSorting(numbers, "bubbleSort");

        System.out.println("\nSelection Sort:");
        testSorting(numbers, "selectionSort");
    }

    private static void testSorting(int[] originalArray, String sortMethod) {
        int[] numbers = Arrays.copyOf(originalArray, originalArray.length);

        System.out.print("\nBefore Sorting: ");
        printArrayElements(numbers);

        if ("bubbleSort".equals(sortMethod)) {
            bubbleSort(numbers);
        } else if ("selectionSort".equals(sortMethod)) {
            selectionSort(numbers);
        }

        System.out.print("\nAfter Sorting: ");
        printArrayElements(numbers);
    }

    private static void bubbleSort(int[] nums) {
        for (int unsortedPartitionIndex = nums.length - 1; unsortedPartitionIndex > 0; unsortedPartitionIndex--) {
            for (int i = 0; i < unsortedPartitionIndex; i++) {
                // Sort in descending order
                if (nums[i] < nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] nums) {
        int n = nums.length;

        for (int lastUnsortedIndex = n - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int smallestIndex = 0;


            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (nums[i] < nums[smallestIndex]) {
                    smallestIndex = i;
                }
            }


            int temp = nums[smallestIndex];
            nums[smallestIndex] = nums[lastUnsortedIndex];
            nums[lastUnsortedIndex] = temp;
        }
    }

    private static void printArrayElements(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
