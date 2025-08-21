import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            map.put(string, map.getOrDefault(string, 0) + 1);

            max = Math.max(max, map.get(string));
        }

        List<String> answer = new ArrayList<>();
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                answer.add(entry.getKey());
            }
        }
        Collections.sort(answer);

        System.out.println(answer.get(0));


    }
}