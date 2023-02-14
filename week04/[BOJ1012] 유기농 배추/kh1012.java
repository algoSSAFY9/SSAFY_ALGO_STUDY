import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class kh1012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
            boolean[][] map = new boolean[N][M];
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());
                map[Y][X] = true;
            }

            int ans = 0;
            int[][] d = {{-1, 0, 1, 0}, {0, 1, 0, -1}};
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (map[n][m]) {
                        ans++;
                        Stack<Integer> stack = new Stack<>();
                        stack.push(n * M + m);
                        map[n][m] = false;
                        while (!stack.isEmpty()) {
                            int rc = stack.pop();
                            int r = rc / M, c = rc % M;
                            for (int i = 0; i < 4; i++) {
                                int next_r = r + d[0][i], next_c = c + d[1][i];
                                if (0 <= next_r && next_r < N && 0 <= next_c && next_c < M && map[next_r][next_c]) {
                                    stack.push(next_r * M + next_c);
                                    map[next_r][next_c] = false;
                                }
                            }
                        }
                    }
                }
            }
            bw.write(ans + "\n");
        }

        bw.flush();
    }
}
