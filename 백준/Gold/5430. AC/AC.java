import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String commend = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String arr = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            if (N > 0) {
                String[] nums = arr.substring(1, arr.length() - 1).split(",");
                for (String num : nums) {
                    deque.add(Integer.parseInt(num));
                }
            }

            boolean reversed = false;
            boolean error = false;

            for (char c : commend.toCharArray()) {
                if (c == 'R') {
                    reversed = !reversed;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (!reversed) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if (!deque.isEmpty()) {
                    if (!reversed) {
                        while (deque.size() > 1) {
                            sb.append(deque.pollFirst()).append(",");
                        }
                        sb.append(deque.pollFirst());
                    } else {
                        while (deque.size() > 1) {
                            sb.append(deque.pollLast()).append(",");
                        }
                        sb.append(deque.pollLast());
                    }
                }
                sb.append("]\n");
            }
        }

        System.out.print(sb);
    }
}