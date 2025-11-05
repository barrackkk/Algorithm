import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Map<Character, int[]> pos = new HashMap<>();
    static Set<Character> leftKeys = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char left = st.nextToken().charAt(0);
        char right = st.nextToken().charAt(0);
        String word = br.readLine();

        String[] keys = {
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };

        for (int y = 0; y < keys.length; y++) {
            for (int x = 0; x < keys[y].length(); x++) {
                char c = keys[y].charAt(x);
                pos.put(c, new int[]{x, y});
            }
        }

        for (char c : "qwertasdfgzxcv".toCharArray()) {
            leftKeys.add(c);
        }

        int time = 0;
        for (char c : word.toCharArray()) {
            if (leftKeys.contains(c)) {
                int[] now = pos.get(left);
                int[] next = pos.get(c);
                time += Math.abs(now[0] - next[0]) + Math.abs(now[1] - next[1]) + 1;
                left = c;
            } else {
                int[] now = pos.get(right);
                int[] next = pos.get(c);
                time += Math.abs(now[0] - next[0]) + Math.abs(now[1] - next[1]) + 1;
                right = c;
            }
        }

        System.out.println(time);
    }
}