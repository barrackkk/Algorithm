import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Main {

    static String line;
    static Stack<Integer> stk = new Stack<>();
    static List<int[]> pair = new ArrayList<>();
    static Set<String> result = new TreeSet<>();
    static Boolean[] remove;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '(') {
                stk.push(i);
            }
            if (c == ')') {
                int start = stk.pop();
                pair.add(new int[]{start, i});
            }
        }
        remove = new Boolean[pair.size()];

        dfs(0);

        for (String s : result) {
            System.out.println(s);
        }

    }

    public static void dfs(int depth) {
        if (depth == pair.size()) {
            StringBuilder sb = new StringBuilder();
            Set<Integer> removeIdx = new TreeSet<>();
            boolean removed = false;
            for (int i = 0; i < pair.size(); i++) {
                int[] e = pair.get(i);
                if (remove[i]) {
                    removed = true;
                    removeIdx.add(e[0]);
                    removeIdx.add(e[1]);
                }
            }

            if (!removed) {
                return;
            }

            for (int i = 0; i < line.length(); i++) {
                if (removeIdx.contains(i)) {
                    continue;
                }
                sb.append(line.charAt(i));
            }

            result.add(String.valueOf(sb));
            return;
        }

        remove[depth] = true;
        dfs(depth + 1);

        remove[depth] = false;
        dfs(depth + 1);
    }
}