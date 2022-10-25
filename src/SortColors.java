import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
//        int[] numbers = new int[]{2,0,2,1,1,0};
        int[] numbers = new int[]{0};
//        int[] numbers = new int[]{5,4,3,2,1};
        sortColors(numbers);
    }

    public static void sortColors(int[] nums) {
        boolean sorted = false;
        int pass = 1;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < nums.length - pass; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i);
                    sorted = false;
                }
            }
            pass++;
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i) {
        int temp = nums[i];
        nums[i] = nums[i + 1];
        nums[i + 1] = temp;
    }
}
