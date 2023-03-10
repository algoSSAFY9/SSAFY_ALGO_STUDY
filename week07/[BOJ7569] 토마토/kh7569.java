import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class kh7569 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());
        int[][][] map = new int[H][N][M];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if (map[h][n][m] == 1) {
                        queue.offer(h * N * M + n * M + m);
                    }
                }
            }
        }

        int[][] directions = {{0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {-1, 0, 0}, {1, 0, 0}};
        while (!queue.isEmpty()) {
            int hnm = queue.poll();
            int h = hnm / (N * M), n = (hnm / M) % N, m = hnm % M;
            for (int[] d : directions) {
                int next_h = h + d[0], next_n = n + d[1], next_m = m + d[2];
                if (0 <= next_h && next_h < H && 0 <= next_n && next_n < N && 0 <= next_m && next_m < M && map[next_h][next_n][next_m] == 0) {
                    queue.offer(next_h * N * M + next_n * M + next_m);
                    map[next_h][next_n][next_m] = map[h][n][m] + 1;
                }
            }
        }

        int ans = 0;
        for (int hnm = 0; hnm < H * N * M; hnm++) {
            int h = hnm / (N * M), n = (hnm / M) % N, m = hnm % M;

            if (map[h][n][m] == 0) {
                ans = 0;
                break;
            }

            ans = Math.max(ans, map[h][n][m]);
        }
        bw.write(String.valueOf(ans - 1));

        bw.flush();
    }
}
