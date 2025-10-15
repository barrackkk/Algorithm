import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static double n1, n2;
    static double result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        Stack<Double> alphabet = new Stack<>();
        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                alphabet.push(arr[c - 'A']);
            } else if (!alphabet.isEmpty()) {
                n1 = alphabet.pop();
                n2 = alphabet.pop();
                switch (c) {
                    case '+' -> {
                        result = n1 + n2;
                    }
                    case '-' -> {
                        result = n2 - n1;
                    }
                    case '*' -> {
                        result = n1 * n2;
                    }
                    case '/' -> {
                        result = n2 / n1;
                    }
                }
                alphabet.push(result);
            }
        }
        
        sb.append(String.format("%.2f", result));
        System.out.println(sb);
    }
}