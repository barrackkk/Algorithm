import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                System.out.println(sb);
                return;
            }
            Stack<Character> stk = new Stack<>();

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (c == '(') {
                    stk.push(c);
                }
                if (c == '[') {
                    stk.push(c);
                }

                if (c == ')') {
                    if (!stk.isEmpty() && stk.peek() == '(') {
                        stk.pop();
                    } else {
                        stk.push(c);
                    }

                }

                if (c == ']') {
                    if (!stk.isEmpty() && stk.peek() == '[') {
                        stk.pop();
                    } else {
                        stk.push(c);
                    }

                }
            }

            if (stk.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
    }
}