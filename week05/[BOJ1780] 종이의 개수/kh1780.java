import java.io.*;
import java.util.StringTokenizer;

public class kh1780 {

    static int[] count;

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

        count = new int[3];
        run(0, 0, N, paper);
        bw.write(count[0] + "\n" + count[1] + "\n" + count[2]);
        bw.flush();
    }

    static void run(int from_i, int from_j, int n, int[][] paper) {
        int tmp = paper[from_i][from_j];
        for (int i = from_i; i < from_i + n; i++) {
            for (int j = from_j; j < from_j + n; j++) {
                if (tmp != paper[i][j]) {
                    run(from_i, from_j, n / 3, paper);
                    run(from_i, from_j + n / 3, n / 3, paper);
                    run(from_i, from_j + n / 3 * 2, n / 3, paper);
                    run(from_i + n / 3, from_j, n / 3, paper);
                    run(from_i + n / 3, from_j + n / 3, n / 3, paper);
                    run(from_i + n / 3, from_j + n / 3 * 2, n / 3, paper);
                    run(from_i + n / 3 * 2, from_j, n / 3, paper);
                    run(from_i + n / 3 * 2, from_j + n / 3, n / 3, paper);
                    run(from_i + n / 3 * 2, from_j + n / 3 * 2, n / 3, paper);
                    return;
                }
            }
        }

        count[tmp + 1]++;
    }
}
