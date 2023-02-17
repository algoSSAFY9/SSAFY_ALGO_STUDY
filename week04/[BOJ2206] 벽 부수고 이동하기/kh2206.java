import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class kh2206 {

    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 2][M + 2];
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1) == '0' ? 1 : 0;
                if (map[i][j] == 0) arr.add(new int[]{i, j});
            }
        }

        int[][] fromStart = new int[N + 2][M + 2];
        bfs(map, 1, 1, fromStart);

        int[][] fromEnd = new int[N + 2][M + 2];
        bfs(map, N, M, fromEnd);

        int ans = fromStart[N][M] == 0 ? Integer.MAX_VALUE : fromStart[N][M];
        int[] next_r = new int[2], next_c = new int[2];
        for (int[] rc : arr) {
            for (int i = 0; i < 4; i++) {
                next_r[0] = rc[0] + directions[i][0];
                next_c[0] = rc[1] + directions[i][1];
                if (fromStart[next_r[0]][next_c[0]] != 0) {
                    for (int j = 1; j < 4; j++) {
                        next_r[1] = rc[0] + directions[(i + j) % 4][0];
                        next_c[1] = rc[1] + directions[(i + j) % 4][1];
                        if (fromEnd[next_r[1]][next_c[1]] != 0) {
                            ans = Math.min(ans, fromStart[next_r[0]][next_c[0]] + fromEnd[next_r[1]][next_c[1]] + 1);
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(ans == Integer.MAX_VALUE ? -1 : ans));
        bw.flush();
    }

    static void bfs(int[][] map, int r, int c, int[][] distance) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        distance[r][c] = 1;
        while (!q.isEmpty()) {
            int[] rc = q.poll();
            for (int[] d : directions) {
                int next_r = rc[0] + d[0], next_c = rc[1] + d[1];
                if (map[next_r][next_c] == 1 && distance[next_r][next_c] == 0) {
                    q.offer(new int[]{next_r, next_c});
                    distance[next_r][next_c] = distance[rc[0]][rc[1]] + 1;
                }
            }
        }
    }
}
