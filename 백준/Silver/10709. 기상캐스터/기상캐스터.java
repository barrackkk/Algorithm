import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < W; j++) {
                list.add(line.charAt(j));
            }
            int cnt = 0;
            boolean hasC = false;
            List<Integer> result = new ArrayList<>();

            for (int j = 0; j < W; j++) {
                char c = list.get(j);
                if (c == 'c') {
                    result.add(0);
                    hasC = true;
                    cnt = 0;
                } else if (hasC && c != 'c') {
                    cnt++;
                    result.add(cnt);
                } else {
                    result.add(-1);
                }
            }

            for (Integer integer : result) {
                System.out.print(integer + " ");
            }
            System.out.println();

        }

    }
}