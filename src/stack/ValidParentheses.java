package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<String> stringStack = new Stack<>();
        int i = 0;
        var input = s.split("");
        List<String> openParentheses = new ArrayList<>();
        List<String> closeParentheses = new ArrayList<>();

        openParentheses.add("(");
        openParentheses.add("[");
        openParentheses.add("{");

        closeParentheses.add(")");
        closeParentheses.add("]");
        closeParentheses.add("}");

        while (i < input.length) {
            if (openParentheses.contains(input[i])) {
                stringStack.add(input[i]);
                i++;
            } else {
                if (!stringStack.empty())
                {
                    var openIndex = openParentheses.indexOf(stringStack.pop());
                    var closeIndex = closeParentheses.indexOf(input[i]);
                    if (openIndex != closeIndex) {
                        return false;
                    }
                }
                else
                    return false;

                i++;
            }
        }
        return stringStack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }
}
