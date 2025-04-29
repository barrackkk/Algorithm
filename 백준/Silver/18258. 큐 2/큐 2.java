import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String menu = st.nextToken();
            if (menu.equals("push")) {
                int a = Integer.parseInt(st.nextToken());
                queue.add(a);
                last = a;
            }
            if (menu.equals("size")) {
                sb.append(queue.size()).append("\n");
            }
            if (menu.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1").append('\n');
                } else {
                    sb.append("0").append('\n');
                }
            }
            if (menu.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(queue.poll()).append('\n');
                }
            }
            if (menu.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(queue.peek()).append('\n');
                }
            }
            if (menu.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(last).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}