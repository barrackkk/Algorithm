import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int toSec(String mmss) {
        String[] p = mmss.split(":");
        return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
    }

    private static String toMMSS(int sec) {
        int m = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d", m, s);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt1 = 0;
        int cnt2 = 0;
        int lead1 = 0;
        int lead2 = 0;
        int prev = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            int sec = toSec(st.nextToken());

            if (cnt1 > cnt2) {
                lead1 += sec - prev;
            } else if (cnt1 < cnt2) {
                lead2 += sec - prev;
            }

            if (team == 1) {
                cnt1++;
            }
            if (team == 2) {
                cnt2++;
            }

            prev = sec;
        }

        int end = 48 * 60;
        if (cnt1 > cnt2) {
            lead1 += end - prev;
        } else if (cnt1 < cnt2) {
            lead2 += end - prev;
        }

        System.out.println(toMMSS(lead1));
        System.out.println(toMMSS(lead2));

    }
}