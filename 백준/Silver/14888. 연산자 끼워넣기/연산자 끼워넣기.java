import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] numbers;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    // 한번 연산하는 행위
    public void recursive(int index, int rel, int plus, int minus, int mul, int div) {
        if (index == N) {
            min = Math.min(min, rel);
            max = Math.max(max, rel);
            return;
        }

        int next = numbers[index];

        if (plus > 0) {
            recursive(index + 1, rel + next, plus - 1, minus, mul, div);
        }
        if (minus > 0) {
            recursive(index + 1, rel - next, plus, minus - 1, mul, div);
        }
        if (mul > 0) {
            recursive(index + 1, rel * next, plus, minus, mul - 1, div);
        }
        if (div > 0) {
            recursive(index + 1, rel / next, plus, minus, mul, div - 1);
        }
    }


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        recursive(1, numbers[0], plus, minus, mul, div);
        System.out.println(max);
        System.out.println(min);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();

    }
}