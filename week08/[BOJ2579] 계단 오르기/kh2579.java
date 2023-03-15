import java.io.*;

public class kh2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N + 1];
        for (int i = 1; i < N + 1; i++) score[i] = Integer.parseInt(br.readLine());

        int[][] dp = new int[3][N + 1];
        dp[1][1] = score[1];
        for (int i = 2; i <= N; i++) {
            dp[0][i] = dp[2][i - 1];
            dp[1][i] = Math.max(dp[0][i - 1] + score[i], dp[1][i - 2] + score[i]);
            dp[2][i] = dp[1][i - 1] + score[i];
        }

        bw.write(String.valueOf(Math.max(dp[1][N], dp[2][N])));
        bw.flush();
    }
}
