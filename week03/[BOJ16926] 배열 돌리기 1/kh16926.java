import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kh16926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        String[][] arr = new String[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = st.nextToken();
            }
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        String[][] tmp = new String[Math.min(N, M) / 2][];
        for (int i = 0, r = 0, c = 0; i < Math.min(N, M) / 2; i++, r++, c++) {
            int size = (N - 1 - (i * 2)) * 2 + (M - 1 - (i * 2)) * 2;
            tmp[i] = new String[size];
            
            int idx = 0;
            for (int j = 0; j < 4; j++) {
                int[] d = directions[j];
                for (int k = 0; k < (j % 2 == 0 ? M : N) - 1 - (i * 2); k++, r += d[0], c += d[1]) {
                    tmp[i][idx++] = arr[r][c];
                }
            }
            
            for (int j = 0; j < 4; j++) {
                int[] d = directions[j];
                for (int k = 0; k < (j % 2 == 0 ? M : N) - 1 - (i * 2); k++, r += d[0], c += d[1]) {
                    arr[r][c] = tmp[i][(idx++ + R) % size];
                }
            }
        }

        for (String[] strings : arr) {
            for (String string : strings) {
                sb.append(string).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
