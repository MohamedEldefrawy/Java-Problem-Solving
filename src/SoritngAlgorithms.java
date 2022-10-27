import java.util.Arrays;

public class SoritngAlgorithms {
    private static int swaps = 0;

    public static void main(String[] args) {
        int[] selectionSortInput = new int[]{5, 4, 3, 2, 1, 0};
        int[] bubbleSortInput = new int[]{5, 4, 3, 2, 1};
        int[] mergeSortInput = new int[]{5, 4, 3, 2, 1, 10, 100, 0, 0};
        int[] quickSortInput = new int[]{10, 16, 8, 12, 15, 6, 3, 9, 5};
        int[] insertionSortInput = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] shellSortInput = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println("Selection sort: " + Arrays.toString(selectionSort(selectionSortInput)));
        System.out.println("Bubble sort: " + Arrays.toString(bubbleSort(bubbleSortInput)));
        System.out.println("Merge sort: " + Arrays.toString(mergeSort(mergeSortInput)));
        quickSort(quickSortInput, 0, quickSortInput.length - 1);
        System.out.println("Quick sort: " + Arrays.toString(quickSortInput) + " swaps= " + swaps);
        insertionSort(insertionSortInput, 0, 1);
        System.out.println("Insertion sort: " + Arrays.toString(insertionSortInput));
        shellSort(shellSortInput);
        System.out.println("Shell sort: " + Arrays.toString(shellSortInput));
    }

    public static void shellSort(int[] numbers) {
        int increment = numbers.length / 2;
        while (increment > 0) {
            for (int i = 0; i < increment; i++) {
                insertionSort(numbers, i, increment);
            }
            increment--;
        }

    }

    public static void insertionSort(int[] numbers, int startIndex, int increment) {
        for (int i = increment; i < numbers.length; i += increment) {
            for (int j = i - increment; j >= 0; j -= increment) {
                if (numbers[i] < numbers[j]) {
                    swap(numbers, i, j);
                    i -= increment;
                } else {
                    break;
                }
            }
        }
    }

    public static void quickSort(int[] numbers, int start, int end) {
        if (start >= end)
            return;

        int newPivot = partition(numbers, start, end);
        quickSort(numbers, start, newPivot - 1);
        quickSort(numbers, newPivot + 1, end);
    }

    public static int partition(int[] numbers, int leftIndex, int rightIndex) {
        int pivot = leftIndex;
        while (leftIndex < rightIndex) {
            // get number larger than pivot from left
            while (leftIndex < rightIndex && numbers[leftIndex] < numbers[pivot])
                leftIndex++;

            // get number less than pivot from right
            while (leftIndex < rightIndex && numbers[rightIndex] >= numbers[pivot])
                rightIndex--;

            // swap them
            swap(numbers, leftIndex, rightIndex);
            swaps++;
        }

        // put pivot in its correct position
        swap(numbers, pivot, rightIndex);
        swaps++;


        // return new pivot index
        return rightIndex;
    }

    /**
     * @param numbers int[]
     * @return result int[]
     * sorting given array using merge sort algorithm
     */
    public static int[] mergeSort(int[] numbers) {
        int mid = numbers.length / 2;

        if (numbers.length == 1) // base case of dividing given array
            return numbers;

        int[] left = new int[mid];
        int[] right = new int[numbers.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = numbers[i]; // populating left array with left half of array
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = numbers[mid]; // populating left array with left half of array
            mid++;
        }

        // recursively dividing arrays
        int[] sortedRight = mergeSort(right);
        int[] sortedLeft = mergeSort(left);

        return merge(sortedRight, sortedLeft);
    }

    /**
     * @param leftArray  int[]
     * @param rightArray int[]
     * @return result int[]
     * take two arrays and return merged sorted array
     */
    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int resultArrayIndex = 0;
        while (leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                result[resultArrayIndex] = leftArray[leftArrayIndex];
                resultArrayIndex++;
                leftArrayIndex++;
            } else if (leftArray[leftArrayIndex] >= rightArray[rightArrayIndex]) {
                result[resultArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
                resultArrayIndex++;
            }
        }

        while (leftArrayIndex < leftArray.length) {
            result[resultArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            resultArrayIndex++;
        }

        while (rightArrayIndex < rightArray.length) {
            result[resultArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            resultArrayIndex++;
        }
        return result;
    }

    /**
     * @param numbers int[]
     * @return result int[]
     * Sorting given array of numbers using selection sort
     */
    public static int[] selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    swap(numbers, i, j);
                }
            }
        }
        return numbers;
    }

    /**
     * @param numbers int[]
     * @return result int[]
     */
    public static int[] bubbleSort(int[] numbers) {
        boolean sorted = false; // Assuming array not sorted
        int pass = 1;
        while (!sorted) {
            sorted = true; // change state to sorted until start swapping operation


            for (int i = 0; i < numbers.length - pass; i++) {
                // loop until
                if (numbers[i] > numbers[i + 1]) {
                    swap(numbers, i, i + 1);
                    sorted = false;
                }
            }
            pass++;
        }
        return numbers;
    }

    /**
     * @param numbers int[]
     * @param i       int  index of first element
     * @param j       int index of second element
     *                Take an array with two targets indecencies nad swap them
     */
    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
