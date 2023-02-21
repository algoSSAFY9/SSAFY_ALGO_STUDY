import java.io.*;
import java.util.StringTokenizer;

public class kh2630 {

    static int white, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        white = blue = 0;
        run(0, 0, N, paper);
        bw.write(white + "\n" + blue);

        bw.flush();
    }

    static void run(int from_i, int from_j, int n, int[][] paper) {
        int tmp = 0;
        for (int i = from_i; i < from_i + n; i++) {
            for (int j = from_j; j < from_j + n; j++) {
                tmp += paper[i][j];
            }
        }

        if (tmp == 0) {
            white++;
            return;
        }

        if (tmp == n * n) {
            blue++;
            return;
        }

        run(from_i, from_j, n / 2, paper);
        run(from_i, from_j + n / 2, n / 2, paper);
        run(from_i + n / 2, from_j, n / 2, paper);
        run(from_i + n / 2, from_j + n / 2, n / 2, paper);
    }
}
