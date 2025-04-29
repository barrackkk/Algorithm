import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                stk.pop();
            } else {
                stk.push(a);
            }
        }
        if (stk.empty()) {
            System.out.println("0");
            return;

        } else {
            for (Integer i : stk) {
                sum += i;
            }
        }
        sb.append(sum);
        System.out.println(sb);
    }
}