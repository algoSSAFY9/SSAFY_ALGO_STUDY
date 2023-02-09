import java.io.*;
import java.util.StringTokenizer;

public class kh17276 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), d = ((Integer.parseInt(st.nextToken()) + 360) % 360) / 45;
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] starts = {{n - 1, 0}, {n / 2, 0}, {0, 0}, {0, n / 2}, {0, n - 1}, {n / 2, n - 1}, {n - 1, n - 1}, {n - 1, n / 2}};
            int[][] directions = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};

            int[][] tmp = new int[4][n];
            for (int i = 0; i < 4; i++) {
                int r = starts[(i + 8 - d) % 8][0], c = starts[(i + 8 - d) % 8][1];
                for (int j = 0; j < n; j++) {
                    tmp[i][j] = arr[r][c];
                    r += directions[(i + 8 - d) % 8][0];
                    c += directions[(i + 8 - d) % 8][1];
                }
            }

            for (int i = 0; i < 4; i++) {
                int r = starts[i][0], c = starts[i][1];
                for (int j = 0; j < n; j++) {
                    arr[r][c] = tmp[i][j];
                    r += directions[i][0];
                    c += directions[i][1];
                }
            }

            for (int[] ints : arr) {
                for (int anInt : ints) {
                    bw.write(anInt + " ");
                }
                bw.newLine();
            }
        }
        bw.flush();
    }
}
