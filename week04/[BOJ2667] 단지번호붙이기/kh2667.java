import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class kh2667 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N + 2][N + 2];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int size = 1;
                    while (!q.isEmpty()) {
                        int[] rc = q.poll();
                        for (int[] d : directions) {
                            int next_r = rc[0] + d[0], next_c = rc[1] + d[1];
                            if (map[next_r][next_c] == 1 && !visited[next_r][next_c]) {
                                q.offer(new int[]{next_r, next_c});
                                visited[next_r][next_c] = true;
                                size++;
                            }
                        }
                    }

                    pq.offer(size);
                }
            }
        }

        bw.write(pq.size() + "\n");
        while (!pq.isEmpty()) bw.write(pq.poll() + "\n");
        bw.flush();
    }
}
