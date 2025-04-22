import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        HashSet<String> arr = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if (state.equals("enter")) {
                arr.add(name);
            } else if (state.equals("leave")) {
                arr.remove(name);
            }
        }
        br.close();

        List<String> result = new ArrayList<>(arr);
        Collections.sort(result, Collections.reverseOrder());
        for (String s : result) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();


    }
}