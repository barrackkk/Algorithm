import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> moveMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int move = Integer.parseInt(st.nextToken());
            deque.addLast(i);               
            moveMap.put(i, move);           
        }

        while (!deque.isEmpty()) {
            int current = deque.pollFirst();  
            sb.append(current).append(" ");   

            if (deque.isEmpty()) {
                break;
            }

            int move = moveMap.get(current);

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < -move; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb);
    }
}