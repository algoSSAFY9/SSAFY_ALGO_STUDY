import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kh1107 {

    static boolean[] btn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        btn = new boolean[10];
        Arrays.fill(btn, true);
        int M = Integer.parseInt(br.readLine());
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) btn[Integer.parseInt(st.nextToken())] = false;
        }

        int ans = Math.abs(N - 100);
        int n, count;

        n = N;
        count = -1;
        while (n >= 0 && (count = isPossible(n)) == -1) n--;
        int floor = (count == -1 ? Integer.MAX_VALUE : Math.abs(N - n) + count);

        n = N;
        count = -1;
        while (n <= N + ans && (count = isPossible(n)) == -1) n++;
        int ceil = (count == -1 ? Integer.MAX_VALUE : Math.abs(N - n) + count);

        ans = Math.min(ans, Math.min(floor, ceil));
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static int isPossible(int n) {
        char[] channel = String.valueOf(n).toCharArray();
        for (char c : channel) {
            if (!btn[c - '0']) {
                return -1;
            }
        }
        return channel.length;
    }
}
