import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > h) {
                stack.pop();
                count++;
            }

            if (stack.isEmpty() || stack.peek() < h) {
                stack.push(h);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() > 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}