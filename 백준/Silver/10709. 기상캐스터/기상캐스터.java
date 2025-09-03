import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[][] arr = new char[H][W];
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                arr[i][j] = line.charAt(j);
            }

            int cnt = 0;
            boolean hasC = false;
            int[][] result = new int[H][W];

            for (int j = 0; j < W; j++) {
                char c = arr[i][j];
                if (c == 'c') {
                    result[i][j] = 0;
                    hasC = true;
                    cnt = 0;
                } else if (hasC && c != 'c') {
                    cnt++;
                    result[i][j] = cnt;
                } else {
                    result[i][j] = -1;
                }
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}