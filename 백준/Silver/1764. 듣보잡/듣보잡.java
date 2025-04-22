import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> dontKnow = new HashSet<>();
        HashSet<String> dontSee = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            dontKnow.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            dontSee.add(br.readLine());
        }

        for (String s : dontSee) {
            if (dontKnow.contains(s)) {
                result.add(s);
            }
        }
        List<String> rel = new ArrayList<>(result);
        Collections.sort(rel);

        sb.append(result.size()).append("\n");
        for (String s : rel) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);

    }
}