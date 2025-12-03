import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> indexToName = new HashMap<>();
        Map<String, Integer> nameToIndex = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            indexToName.put(i, name);
            nameToIndex.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String line = br.readLine();

            try {
                int numbering = Integer.parseInt(line);
                sb.append(indexToName.get(numbering) + "\n");
            } catch (NumberFormatException e) {
                sb.append(nameToIndex.get(line) + "\n");
            }

        }
        System.out.print(sb);
    }
}