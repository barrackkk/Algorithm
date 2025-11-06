import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] count = new int[101];
        int[] time = new int[101];
        boolean[] in = new boolean[101];
        List<Integer> frames = new ArrayList<>(N);

        st = new StringTokenizer(br.readLine());
        for (int t = 0; t < M; t++) {
            int studentId = Integer.parseInt(st.nextToken());

            if (in[studentId]) {
                count[studentId]++;
                continue;
            }

            if (frames.size() < N) {
                in[studentId] = true;
                count[studentId] = 1;
                time[studentId] = t;
                frames.add(studentId);
                continue;
            }

            int deleted = frames.get(0);
            for (int x : frames) {
                if (count[x] < count[deleted]) {
                    deleted = x;
                } else if (count[x] == count[deleted] && time[x] < time[deleted]) {
                    deleted = x;
                }
            }
            in[deleted] = false;
            count[deleted] = 0;
            time[deleted] = 0;
            frames.remove((Integer) deleted);

            in[studentId] = true;
            count[studentId] = 1;
            time[studentId] = t;
            frames.add(studentId);
        }

        Collections.sort(frames);
        for (int x : frames) {
            sb.append(x).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}