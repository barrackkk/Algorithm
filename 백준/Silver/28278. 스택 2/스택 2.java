import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            switch (num) {
                case 1 -> {
                    int pushNum = Integer.parseInt(st.nextToken());
                    stk.push(pushNum);
                }
                case 2 -> {
                    if (stk.empty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stk.pop());
                    }
                }
                case 3 -> {
                    System.out.println(stk.size());
                }
                case 4 -> {
                    System.out.println(stk.empty() ? "1" : "0");
                }
                case 5 -> {
                    if (stk.empty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stk.peek());
                    }
                }
            }
        }
    }
}