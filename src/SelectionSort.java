import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] input = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(selectionSort(input)));
    }

    public static int[] selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }
}
