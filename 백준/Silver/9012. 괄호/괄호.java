import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Stack<Character> stk = new Stack<>();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                if (c == '(') {
                    stk.push(c);
                } else if (c == ')') {

                    if (stk.empty()) {
                        stk.push(c);
                    } else if (stk.peek().equals('(')) {
                        stk.pop();
                    } else if (stk.peek().equals(')')) {
                        stk.push(c);
                    }
                }
            }
            if (stk.empty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
            stk.clear();

        }
        System.out.println(sb);

    }
}