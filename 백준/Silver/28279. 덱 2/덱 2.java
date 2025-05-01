import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> deq = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            switch (a) {
                case "1" -> {
                    Integer b = Integer.parseInt(st.nextToken());
                    deq.addFirst(b);
                }
                case "2" -> {
                    Integer b = Integer.parseInt(st.nextToken());
                    deq.addLast(b);
                }
                case "3" -> {
                    if (deq.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deq.pollFirst()).append("\n");
                    }
                }
                case "4" -> {
                    if (deq.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deq.pollLast()).append("\n");
                    }
                }
                case "5" -> {
                    sb.append(deq.size()).append("\n");
                }
                case "6" -> {
                    if (deq.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                }
                case "7" -> {
                    if (deq.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deq.getFirst()).append("\n");
                    }
                }
                case "8" -> {
                    if (deq.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deq.getLast()).append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}