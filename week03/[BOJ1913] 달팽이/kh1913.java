import java.io.*;

public class kh1913 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int r = 0, c = 0;
        int num = N * N;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        arr[N / 2][N / 2] = 1;
        int[] ans = {N / 2, N / 2};
        for (int i = N; i > 1; i -= 2) {
            for (int[] d : directions) {
                for (int j = 0; j < i - 1; j++) {
                    if (num == n) {
                        ans[0] = r;
                        ans[1] = c;
                    }

                    arr[r][c] = num--;
                    r += d[0];
                    c += d[1];
                }
            }
            r++;
            c++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }
        bw.write((ans[0] + 1) + " " + (ans[1] + 1));
        bw.flush();
    }
}
