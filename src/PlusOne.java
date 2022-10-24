import java.util.Arrays;

class PlusOne {
    public static void main(String[] args) {
        var result = plusOne(new int[]{9});
        System.out.println(Arrays.toString(result));
    }

    public static int[] add(int[] digits, int end) {

        if (digits[0] == 0 && digits.length > 1)
            return digits;

        if (digits[end] < 9) {
            digits[end] = ++digits[end];
        } else if (digits.length > 1) {
            digits[end] = 0;
            add(digits, end - 1);
        } else {
            digits[end] = 0;
        }
        return digits;
    }

    public static int[] plusOne(int[] digits) {
        int[] semiResult = add(digits, digits.length - 1);
        int[] result;

        if (semiResult[0] == 0) {
            result = new int[semiResult.length + 1];
            result[0] = 1;
            for (int i = 1; i < semiResult.length; i++) {
                result[i] = semiResult[i];
            }
        } else {
            result = new int[semiResult.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = semiResult[i];
            }
        }

        return result;

    }
}