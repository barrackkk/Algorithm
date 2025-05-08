import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void recursive(int N, int M, List<Integer> lists, int current) {
        if (M == current) {
            for (int i = 0; i < lists.size(); i++) {
                System.out.print(lists.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (lists.contains(i)) {
                continue;
            }
            if (!lists.isEmpty() && lists.get(lists.size() - 1) > i) {
                continue;
            }

            lists.add(i);
            recursive(N, M, lists, current + 1);
            lists.remove(lists.size() - 1);

        }
    }


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        recursive(N, M, new ArrayList<>(), 0);


    }
}