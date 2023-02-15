import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kh7562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] knight = {Integer.parseInt(st.nextToken()) + 2, Integer.parseInt(st.nextToken()) + 2};
            st = new StringTokenizer(br.readLine());
            int[] goal = {Integer.parseInt(st.nextToken()) + 2, Integer.parseInt(st.nextToken()) + 2};

            ArrayDeque<int[]> q = new ArrayDeque<>();
            int[][] visited = new int[l + 4][l + 4];
            for (int i = 2; i <= l + 1; i++) Arrays.fill(visited[i], 2, l + 2, -1);
            int[][] directions = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
            q.offer(new int[]{knight[0], knight[1]});
            visited[knight[0]][knight[1]] = 0;
            while (visited[goal[0]][goal[1]] == -1) {
                knight = q.poll();
                for (int[] d : directions) {
                    int next_r = knight[0] + d[0], next_c = knight[1] + d[1];
                    if (visited[next_r][next_c] == -1) {
                        q.offer(new int[]{next_r, next_c});
                        visited[next_r][next_c] = visited[knight[0]][knight[1]] + 1;
                    }
                }
            }

            bw.write(visited[goal[0]][goal[1]] + "\n");
        }
        bw.flush();
    }
}
