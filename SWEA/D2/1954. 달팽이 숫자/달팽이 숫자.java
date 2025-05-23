import java.util.Scanner;

public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];

            int x = 0, y = 0, dir = 0;
            for (int i = 1; i <= n * n; i++) {
                map[x][y] = i;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (ny < 0 || nx >= n || ny >= n || map[nx][ny] != 0) {
                    dir = (dir + 1) % 4; 
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                x = nx;
                y = ny;
            }

            System.out.println("#" + tc);
            for (int[] row : map) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }
}