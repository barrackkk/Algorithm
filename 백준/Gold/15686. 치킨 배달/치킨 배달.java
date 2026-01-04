import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N, M;

    static List<int[]> chickenXY = new ArrayList<>();
    static List<int[]> houseXY = new ArrayList<>();

    static int answer = Integer.MAX_VALUE;
    static boolean[] selected; 

    static int calcCityChickenDistance() {
        int sum = 0;

        for (int[] h : houseXY) {
            int hx = h[0], hy = h[1];
            int best = Integer.MAX_VALUE;

            for (int i = 0; i < chickenXY.size(); i++) {
                if (!selected[i]) {
                    continue;
                }
                int[] c = chickenXY.get(i);
                int cx = c[0], cy = c[1];
                int dist = Math.abs(hx - cx) + Math.abs(hy - cy);
                if (dist < best) {
                    best = dist;
                }
            }

            sum += best;

            if (sum >= answer) {
                return sum;
            }
        }

        return sum;
    }

    static void chooseChicken(int start, int picked) {
        if (picked == M) {
            answer = Math.min(answer, calcCityChickenDistance());
            return;
        }

        if (start == chickenXY.size()) {
            return;
        }

        for (int i = start; i < chickenXY.size(); i++) {
            selected[i] = true;
            chooseChicken(i + 1, picked + 1);
            selected[i] = false;
        }
    }

    static void cntChicken() {
        chickenXY.clear();
        houseXY.clear();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    chickenXY.add(new int[]{i, j});
                } else if (map[i][j] == 1) {
                    houseXY.add(new int[]{i, j});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cntChicken();

        selected = new boolean[chickenXY.size()];
        chooseChicken(0, 0);

        System.out.println(answer);
    }
}