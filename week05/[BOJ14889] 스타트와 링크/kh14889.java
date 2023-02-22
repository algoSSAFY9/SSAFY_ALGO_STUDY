import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class kh14889 {

    static int N;
    static int[][] S;
    static int[] start;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;
        start = new int[N / 2];
        start[0] = 0;
        solution(1, 1);
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void solution(int cnt, int from) {
        if (cnt == N / 2) {
            ArrayList<Integer> link = new ArrayList<>();
            int idx = 0, player = 0;
            while (player < N) {
                if (idx == N / 2 || start[idx] != player) link.add(player);
                else idx++;

                player++;
            }

            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N / 2; j++) {
                    sum1 += S[start[i]][start[j]];
                    sum2 += S[link.get(i)][link.get(j)];
                }
            }

            ans = Math.min(ans, Math.abs(sum1 - sum2));
            return;
        }

        for (int i = from; i < N; i++) {
            start[cnt] = i;
            solution(cnt + 1, i + 1);
        }
    }
}
