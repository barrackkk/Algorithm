import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map1.put(name, i);
            map2.put(i, name);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            try {
                int num = Integer.parseInt(s);
                System.out.println(map2.get(num));
            } catch (NumberFormatException e) {
                System.out.println(map1.get(s));
            }
        }

    }
}