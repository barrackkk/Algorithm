import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[][] str = new String[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            str[i][0] = (st.nextToken());
            str[i][1] = (st.nextToken());
        }
        br.close();

        Arrays.sort(str, (e1, e2) -> {
            int a = Integer.parseInt(e1[0]);
            int b = Integer.parseInt(e2[0]);
            return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
        });
        
        for (int i = 0; i < n; i++) {
            bw.write(str[i][0] + " " + str[i][1] + "\n");
        }
        bw.flush();
        bw.close();
    }


}