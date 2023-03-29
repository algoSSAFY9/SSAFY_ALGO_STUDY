import java.io.*;
import java.util.StringTokenizer;

public class kh1389 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    dp[i][j] = N - 1;
                }
            }
        }

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            dp[A][B] = dp[B][A] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int ans = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int kb = 0;
            for (int j = 0; j < N; j++) {
                kb += dp[i][j];
            }

            if (kb < min) {
                ans = i;
                min = kb;
            }
        }
        bw.write(String.valueOf(ans + 1));
        bw.flush();
    }
}
