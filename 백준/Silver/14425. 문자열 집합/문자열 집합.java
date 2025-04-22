import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        String[] findArr = new String[m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            findArr[i] = br.readLine();
            for (int j = 0; j < n; j++) {
                if (findArr[i].equals(arr[j])) {
                    cnt++;
                }
            }
        }
        br.close();

        bw.write(cnt + "");
        bw.flush();
        bw.close();


    }
}