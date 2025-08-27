import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>(n);

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> idx = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
            map.put(x, map.getOrDefault(x, 0) + 1);
            idx.putIfAbsent(x, i);
        }

        list.sort((i1, i2) -> {
            if (map.get(i1) != map.get(i2)) {
                return Integer.compare(map.get(i2), map.get(i1));
            }
            return Integer.compare(idx.get(i1), idx.get(i2));
        });

        StringBuilder sb = new StringBuilder();
        for (int x : list) {
            sb.append(x).append(' ');
        }
        System.out.println(sb);
    }
}