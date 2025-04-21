import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(st.nextToken());
        int b = 100;
        List<String> str = new ArrayList<>();
        int c = 0;
        while (b > 0) {
            b = a;
            c = a % 10;
            a = a / 10;

            if (b == 0) {
                break;
            }
            str.add(String.valueOf(c));
        }
        br.close();
        Collections.sort(str, Collections.reverseOrder());
        for (String s : str) {

            bw.write(s + "");
        }
        bw.flush();
        bw.close();

    }
}