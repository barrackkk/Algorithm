import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void recursive(int N, int M, List<Integer> lists, int current) {
        if (M == current) {
            for (int i = 0; i < lists.size(); i++) {
                sb.append(lists.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            lists.add(i);
            recursive(N, M, lists, current + 1);
            lists.remove(lists.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        recursive(N, M, new ArrayList<>(), 0);
        
        System.out.println(sb);


    }
}