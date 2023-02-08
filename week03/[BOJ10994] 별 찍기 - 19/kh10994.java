import java.io.*;

public class kh10994 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int length = 1 + (N - 1) * 4;
        boolean[][] stars = new boolean[length][length];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = 0, c = 0;
        for (int i = N; i > 0; i--) {
            for (int[] d : directions) {
                for (int j = 0; j < (i - 1) * 4; j++) {
                    stars[r][c] = true;
                    r += d[0];
                    c += d[1];
                }
            }

            r += 2;
            c += 2;
        }
        stars[length / 2][length / 2] = true;

        for (boolean[] star : stars) {
            for (boolean s : star) {
                bw.write(s ? "*" : " ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}
