import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            Stack<Character> stk = new Stack<>();
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if (!stk.isEmpty() && c == stk.peek()) {
                    stk.pop();
                    continue;
                }

                stk.push(c);

            }

            if (stk.isEmpty()) {
                result++;
            }
        }

        sb.append(result);
        System.out.println(sb);


    }
}