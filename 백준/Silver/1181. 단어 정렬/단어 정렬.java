import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] str;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        br.close();
        str = set.toArray(new String[0]);

        Arrays.sort(str, (e1, e2) -> {
            if (e1.length() == e2.length()) {
                return e1.compareTo(e2);
            } else {
                return e1.length() - e2.length();
            }
        });

        for (String s : str) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
    }
}