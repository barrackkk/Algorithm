import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        int[] soldiers = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
            soldiers[i] = 1;
        }

        Collections.reverse(arr);

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(i) > arr.get(j)) {
                    soldiers[i] = Math.max(soldiers[i], soldiers[j] + 1);
                }
            }
            max = Math.max(max, soldiers[i]);
        }
        System.out.println(N - max);

    }
}