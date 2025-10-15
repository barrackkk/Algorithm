import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n1; i++) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{i, num});
            }

            int cnt = 0;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                int max = 0;
                for (int[] q : queue) {
                    max = Math.max(max, q[1]);
                }

                if (cur[1] < max) {
                    queue.offer(cur);
                } else {
                    cnt++;
                    if (cur[0] == n2) {
                        sb.append(cnt);
                        break;
                    }
                }
            }
            System.out.println(sb);
        }
    }
}