package algorithm_study.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BS9_10830 {

    static int N;
    static long B;
    static int[][] rc;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        rc = new int[N][N];
        int[][] ans = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int t = Integer.parseInt(st.nextToken());
                rc[i][j] = t % 1000;
                ans[i][j] = t;
            }
        }
        ans = dfs(ans, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[][] dfs(int[][] a, long depth) {
        if (depth == 1) {
            return rc;
        }

        int[][] temp = dfs(a, depth / 2);

        if (depth % 2 == 1) {
            return cal(cal(temp, temp), a);
        }
        return cal(temp, temp);
    }

    static int[][] cal(int[][] a, int[][] b) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[i][j] += (a[i][k] * b[k][j]);
                }
                temp[i][j] %= 1000;
            }
        }
        return temp;
    }
}
