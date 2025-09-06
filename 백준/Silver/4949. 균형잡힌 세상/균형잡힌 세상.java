import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String line = "";
        while (true) {
            line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            Stack<Character> stk1 = new Stack<>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '(') {
                    stk1.push(c);
                }
                if (c == '[') {
                    stk1.push(c);
                }

                if (c == ')') {
                    if (!stk1.isEmpty() && stk1.peek() == '(') {
                        stk1.pop();
                    } else {
                        stk1.push(c);
                    }
                }

                if (c == ']') {
                    if (!stk1.isEmpty() && stk1.peek() == '[') {
                        stk1.pop();
                    } else {
                        stk1.push(c);
                    }
                }
            }
            if (stk1.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
    }
}