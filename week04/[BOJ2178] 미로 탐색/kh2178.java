import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class kh2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N + 2][M + 2];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i + 1][j + 1] = str.charAt(j) - '0';
            }
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Deque<Data> q = new ArrayDeque<>();
        q.offer(new Data(1, 1, 1));
        maze[1][1] = 0;
        int ans = 0;
        while (!q.isEmpty() && ans == 0) {
            Data data = q.poll();
            for (int[] d : directions) {
                int next_i = data.i + d[0], next_j = data.j + d[1];
                if (maze[next_i][next_j] == 1) {
                    if (next_i == N && next_j == M) {
                        ans = data.count + 1;
                        break;
                    }
                    q.offer(new Data(next_i, next_j, data.count + 1));
                    maze[next_i][next_j] = 0;
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}

class Data {
    int i;
    int j;
    int count;

    public Data(int i, int j, int count) {
        this.i = i;
        this.j = j;
        this.count = count;
    }
}
