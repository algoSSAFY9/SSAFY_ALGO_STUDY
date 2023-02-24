import java.io.*;

public class kh9663 {

    static int N;
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[3][];
        visited[2] = new boolean[N];
        for (int i = 0; i < 2; i++) visited[i] = new boolean[N * 2 - 1];

        ans = 0;
        solution(0);

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void solution(int r) {
        if (r == N) {
            ans++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (!visited[2][c] && !visited[0][r + c] && !visited[1][c - r + (N - 1)]) {
                visited[2][c] = visited[0][r + c] = visited[1][c - r + (N - 1)] = true;
                solution(r + 1);
                visited[2][c] = visited[0][r + c] = visited[1][c - r + (N - 1)] = false;
            }
        }
    }
}
