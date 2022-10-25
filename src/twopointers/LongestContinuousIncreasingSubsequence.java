package twopointers;

import java.util.ArrayList;
import java.util.List;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
//        var result = findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
//        var result = findLengthOfLCIS(new int[]{5, 5, 5, 5, 5});
        var result = findLengthOfLCIS(new int[]{1, 3, 5, 4, 2, 3, 4, 5});
        System.out.println(result);

    }

    public static int findLengthOfLCIS(int[] nums) {
        int left = 0;
        int right = 1;
        int counter = 1;
        List<Integer> results = new ArrayList<>();
        if (nums.length == 1)
            return 1;
        else {
            while (right < nums.length) {
                if (nums[left] < nums[right]) {
                    left = right;
                    right++;
                    counter++;
                } else {
                    results.add(counter);
                    counter = 1;
                    left = right;
                    right++;
                }
            }
        }
        results.add(counter);
        int max = results.get(0);
        for (var number : results
        ) {
            if (max < number)
                max = number;
        }
        return max;

    }
}
