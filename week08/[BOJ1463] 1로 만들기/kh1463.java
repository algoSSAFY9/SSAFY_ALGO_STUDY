import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class kh1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        queue.offer(1);
        dp[1] = 0;
        while (dp[N] == -1) {
            int n = queue.poll();

            if (dp[n + 1] == -1) {
                queue.offer(n + 1);
                dp[n + 1] = dp[n] + 1;
            }

            if (n * 2 <= N && dp[n * 2] == -1) {
                queue.offer(n * 2);
                dp[n * 2] = dp[n] + 1;
            }

            if (n * 3 <= N && dp[n * 3] == -1) {
                queue.offer(n * 3);
                dp[n * 3] = dp[n] + 1;
            }
        }
        bw.write(String.valueOf(dp[N]));
        bw.flush();
    }
}
