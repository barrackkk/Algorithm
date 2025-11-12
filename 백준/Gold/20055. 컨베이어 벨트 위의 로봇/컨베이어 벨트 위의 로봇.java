import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = 2 * N;
        int[] A = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 시작 인덱스(s): 올리는 위치의 실제 인덱스
        int s = 0;
        boolean[] robots = new boolean[N]; // 윗면만

        int zeroCount = 0;
        for (int x : A) {
            if (x == 0) {
                zeroCount++;
            }
        }

        int step = 0;

        while (zeroCount < K) {
            step++;

            // 1) 회전
            s = (s - 1 + M) % M;
            // 로봇들 위치도 한 칸 오른쪽으로 밀림
            for (int i = N - 1; i >= 1; i--) {
                robots[i] = robots[i - 1];
            }
            robots[0] = false; // 올리는 위치로 새로 올라오지 않음(아직)
            robots[N - 1] = false; // 내리는 위치에서 내려감

            // 2) 로봇 이동 (뒤에서 앞으로)
            for (int i = N - 2; i >= 0; i--) {
                if (robots[i] && !robots[i + 1]) {
                    int nextIdx = (s + i + 1) % M; // 실제 내구도 인덱스
                    if (A[nextIdx] > 0) {
                        robots[i] = false;
                        robots[i + 1] = true;
                        A[nextIdx]--;
                        if (A[nextIdx] == 0) {
                            zeroCount++;
                        }
                    }
                }
            }
            robots[N - 1] = false; // 이동 후에도 내리는 위치면 내려감

            // 3) 올리는 위치에 로봇 올리기
            int upIdx = s; // 실제 올리는 위치 인덱스
            if (!robots[0] && A[upIdx] > 0) {
                robots[0] = true;
                A[upIdx]--;
                if (A[upIdx] == 0) {
                    zeroCount++;
                }
            }

            // 4) 종료 조건 확인은 while 조건으로 처리
        }

        System.out.println(step);
    }
}