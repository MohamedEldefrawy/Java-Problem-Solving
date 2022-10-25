import java.util.Arrays;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] input = new int[]{5,4,3,2,1};
        System.out.println("Selection sort: " + Arrays.toString(selectionSort(input)));
        System.out.println("Bubble sort: " + Arrays.toString(bubbleSort(input)));
    }

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

    public static int[] bubbleSort(int[] numbers) {
        boolean sorted = false;
        int pass = 1;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < numbers.length - pass; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    swap(numbers, numbers[i], numbers[i + 1]);
                    sorted = false;
                }
            }
            pass++;
        }
        return numbers;
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
