import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class kh16236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int r = -1, c = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    r = i;
                    c = j;
                }
            }
        }
        map[r][c] = 0;

        int shark = 2, fish = 0, ans = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        int t = 0;
        int[] victim = null;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] rc = q.poll();
                for (int[] d : directions) {
                    int next_r = rc[0] + d[0], next_c = rc[1] + d[1];
                    if (0 <= next_r && next_r < N && 0 <= next_c && next_c < N && map[next_r][next_c] <= shark && !visited[next_r][next_c]) {
                        if (map[next_r][next_c] != 0 && map[next_r][next_c] < shark) {
                            if (victim == null || (victim[0] == next_r && next_c < victim[1]) || next_r < victim[0]) {
                                victim = new int[]{next_r, next_c};
                            }
                        } else {
                            q.offer(new int[]{next_r, next_c});
                            visited[next_r][next_c] = true;
                        }
                    }
                }
            }
            t++;

            if (victim != null) {
                map[victim[0]][victim[1]] = 0;
                if (++fish == shark) {
                    shark++;
                    fish = 0;
                }
                ans += t;

                q.clear();
                visited = new boolean[N][N];
                q.offer(new int[]{victim[0], victim[1]});
                visited[victim[0]][victim[1]] = true;
                t = 0;
                victim = null;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
