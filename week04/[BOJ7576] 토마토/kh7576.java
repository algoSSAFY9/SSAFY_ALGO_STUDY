import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kh7576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(i * M + j);
                }
            }
        }

        int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int ij = queue.poll();
            int i = ij / M, j = ij % M;
            for (int l = 0; l < 4; l++) {
                int next_i = i + d[l][0], next_j = j + d[l][1];
                if (0 <= next_i && next_i < N && 0 <= next_j && next_j < M && map[next_i][next_j] == 0) {
                    queue.offer(next_i * M + next_j);
                    map[next_i][next_j] = map[i][j] + 1;
                }
            }
        }

        int ans = 0;
        for (int ij = 0; ij < N * M; ij++) {
            int i = ij / M, j = ij % M;

            if (map[i][j] == 0) {
                ans = 0;
                break;
            }

            ans = Math.max(ans, map[i][j]);
        }
        bw.write(String.valueOf(ans - 1));

        bw.flush();
    }
}
