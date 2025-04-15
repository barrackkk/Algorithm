import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        int[][] arr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String str = br.readLine();
            for (int j = 0; j < cols; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = 0;
                }
                if (str.charAt(j) == 'B') {
                    arr[i][j] = 1;
                }
            }
        }

        int min;
        int rel = 2100000000;
        for (int i = 0; i <= rows - 8; i++) {
            for (int j = 0; j <= cols - 8; j++) {
                int whiteStart = count(arr, i, j, 0);
                int blackStart = count(arr, i, j, 1);
                min = Math.min(blackStart, whiteStart);
                rel = Math.min(min, rel);
                
            }
        }

        System.out.println(rel);
    }

    private static int count(int[][] arr, int row, int col, int startColor) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int expectColor = (startColor + i + j) % 2;
                if (arr[row + i][col + j] != expectColor) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

