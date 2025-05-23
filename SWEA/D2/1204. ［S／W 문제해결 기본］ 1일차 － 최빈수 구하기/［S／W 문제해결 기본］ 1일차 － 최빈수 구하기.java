import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int testCaseNumber = Integer.parseInt(br.readLine());

            int[] count = new int[101];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                count[score]++;
            }

            int maxScore = 0;
            for (int i = 0; i <= 100; i++) {
                if (count[i] >= count[maxScore]) {
                    maxScore = i;
                }
            }

            System.out.println("#" + testCaseNumber + " " + maxScore);
        }
    }
}