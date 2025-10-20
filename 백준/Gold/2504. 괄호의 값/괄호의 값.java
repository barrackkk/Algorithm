import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int mul = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                mul *= 2;
                stack.push(c);
            } else if (c == '[') {
                mul *= 3;
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                if (s.charAt(i - 1) == '(') {
                    result += mul;
                }
                stack.pop();
                mul /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                if (s.charAt(i - 1) == '[') {
                    result += mul;
                }
                stack.pop();
                mul /= 3;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}