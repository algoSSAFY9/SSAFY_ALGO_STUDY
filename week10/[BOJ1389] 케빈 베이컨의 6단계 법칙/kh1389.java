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

        int[][] dp = new int[N][];
        for (int i = 0; i < N; i++) {
            dp[i] = new int[i];
            for (int j = 0; j < i; j++) {
                dp[i][j] = 6;
            }
        }

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;

            if (A < B) {
                int tmp = A;
                A = B;
                B = tmp;
            }

            dp[A][B] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[k][i] + dp[k][j]);
                }
            }
            for (int i = k + 1; i < N; i++) {
                for (int j = 0; j < k; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
                for (int j = k + 1; j < i; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[j][k]);
                }
            }
        }

        int ans = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int kb = 0;
            for (int j = 0; j < i; j++) kb += dp[i][j];
            for (int j = i + 1; j < N; j++) kb += dp[j][i];

            if (kb < min) {
                ans = i;
                min = kb;
            }
        }
        bw.write(String.valueOf(ans + 1));
        bw.flush();
    }
}
