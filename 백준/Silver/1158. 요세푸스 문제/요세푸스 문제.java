import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> result = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;

            if (cnt % K == 0) {
                result.add(queue.poll());
            } else {
                queue.add(queue.poll());
            }

        }

        sb.append("<");
        for (int i = 0; i < N; i++) {
            int num = result.poll();
            if (i == N - 1) {
                sb.append(num).append(">");
            } else {
                sb.append(num).append(", ");
            }
        }

        System.out.println(sb);

    }
}