import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stk = new Stack<>();
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a != 0) {
                stk.push(a);
            } else {
                stk.pop();
            }
        }
        int sum = 0;
        if (stk.empty()) {
            System.out.println("0");
            return;

        } else {
            for (Integer i : stk) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}