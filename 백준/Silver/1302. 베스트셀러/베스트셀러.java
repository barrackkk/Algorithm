import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            arr[i] = string;
            map.put(arr[i], 0);
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            if (map.get(arr[i]) == 0) {
                for (int j = 0; j < N; j++) {
                    if (arr[i].equals(arr[j])) {
                        cnt++;
                    }
                }
                map.replace(arr[i], cnt);
            }
        }

        int max = Integer.MIN_VALUE;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }

        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                answer.add(entry.getKey());
            }
        }

        Collections.sort(answer);
        System.out.println(answer.get(0));
    }
}