import java.io.*;
import java.util.StringTokenizer;

public class kh10830 {

    static int N;
    static long B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] C = pow(A, B);
        for (int[] ints : C) {
            for (int anInt : ints) {
                bw.write(anInt + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }

    static int[][] pow(int[][] A, long B) {
        if (B == 1) return A;

        int[][] C = pow(A, B / 2);

        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) result[i][j] += C[i][k] * C[k][j];
                result[i][j] %= 1000;
            }
        }

        if (B % 2 == 1) {
            int[][] tmp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) tmp[i][j] += result[i][k] * A[k][j];
                    tmp[i][j] %= 1000;
                }
            }
            result = tmp;
        }

        return result;
    }
}
