import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();

                map.put(s2, map.getOrDefault(s2, 0) + 1);
            }

            long result = 1;
            for (int count : map.values()) {
                result *= (count + 1);
            }
            result--;

            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}