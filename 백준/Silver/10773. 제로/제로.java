import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number != 0) {
                stk.push(number);
            } else {
                stk.pop();
            }
        }

        int sum = 0;
        for (Integer i : stk) {
            sum += i;
        }

        System.out.println(sum);

    }
}