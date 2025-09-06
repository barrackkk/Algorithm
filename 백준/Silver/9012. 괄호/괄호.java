import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            Stack<Character> stk = new Stack<>();
            String line = br.readLine();
            boolean tf = true;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (c == '(') {
                    stk.push(c);
                }
                if (c == ')') {
                    if (!stk.isEmpty() && stk.peek() == '(') {
                        stk.pop();
                    } else if (stk.isEmpty()) {
                        tf = false;
                        break;
                    }
                }
            }

            if (stk.isEmpty() && tf) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
}