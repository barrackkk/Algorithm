import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();
        int cnt = 1;

        for (int t = 0; t < T; t++) {
            int number = Integer.parseInt(br.readLine());

            while (cnt <= number) {
                stk.push(cnt++);
                sb.append("+\n");
            }

            if (stk.peek() == number) {
                sb.append("-\n");
                stk.pop();
            }
        }

        if (stk.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

    }
}