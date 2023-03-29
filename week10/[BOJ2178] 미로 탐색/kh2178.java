import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class kh2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N + 2][M + 2];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i + 1][j + 1] = str.charAt(j) - '0';
            }
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[N + 2][M + 2];
        q.offer(new int[]{1, 1});
        visited[1][1] = 1;
        while (visited[N][M] == 0) {
            int[] ij = q.poll();
            for (int[] d : directions) {
                int next_i = ij[0] + d[0], next_j = ij[1] + d[1];
                if (maze[next_i][next_j] == 1 && visited[next_i][next_j] == 0) {
                    q.offer(new int[]{next_i, next_j});
                    visited[next_i][next_j] = visited[ij[0]][ij[1]] + 1;
                }
            }
        }
        bw.write(String.valueOf(visited[N][M]));
        bw.flush();
    }
}
