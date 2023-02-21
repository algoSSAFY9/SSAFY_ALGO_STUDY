import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kh1992 {

    static StringBuilder sb;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        sb = new StringBuilder();
        solution(0, 0, N);
        System.out.println(sb);
    }

    static void solution(int r, int c, int n) {
        int bit = arr[r][c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[r + i][c + j] != bit) {
                    sb.append('(');
                    solution(r, c, n / 2);
                    solution(r, c + n / 2, n / 2);
                    solution(r + n / 2, c, n / 2);
                    solution(r + n / 2, c + n / 2, n / 2);
                    sb.append(')');
                    return;
                }
            }
        }

        sb.append(bit);
    }
}
