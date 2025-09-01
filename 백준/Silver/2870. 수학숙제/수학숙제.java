import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<BigInteger> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if (Character.isDigit(c)) {
                    sb.append(c); 
                } else {
                    if (sb.length() > 0) { 
                        list.add(new BigInteger(sb.toString()));
                        sb.setLength(0);
                    }
                }

                if (j == line.length() - 1 && sb.length() > 0) {
                    list.add(new BigInteger(sb.toString()));
                    sb.setLength(0);
                }
            }
        }

        Collections.sort(list);

        for (BigInteger num : list) {
            System.out.println(num);
        }
    }
}