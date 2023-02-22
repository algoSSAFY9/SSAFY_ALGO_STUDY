import java.io.*;
import java.util.StringTokenizer;

public class kh14888 {

    static int N;
    static int[] num;
    static int[] op;
    static boolean[] visited;
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());

        op = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) op[idx++] = i;
        }

        visited = new boolean[N - 1];
        max = -1000000000;
        min = 1000000000;
        solution(0, num[0]);

        bw.write(max + "\n" + min);
        bw.flush();
    }

    static void solution(int idx, int result) {
        if (idx == N - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                switch (op[i]) {
                    case 0:
                        solution(idx + 1, result + num[idx + 1]);
                        break;
                    case 1:
                        solution(idx + 1, result - num[idx + 1]);
                        break;
                    case 2:
                        solution(idx + 1, result * num[idx + 1]);
                        break;
                    case 3:
                        solution(idx + 1, result / num[idx + 1]);
                        break;
                }
                visited[i] = false;
            }
        }
    }
}
