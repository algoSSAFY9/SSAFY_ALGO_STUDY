import java.io.*;
import java.util.StringTokenizer;

public class kh6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            int gcd = euclidean(M, N);
            int lcm = M * N / gcd;
            int ans = -1;
            for (int k = x; k < lcm; k += M) {
                if (k % N == y) {
                    ans = k + 1;
                    break;
                }
            }
            bw.write(String.valueOf(ans));
            bw.newLine();
        }
        bw.flush();
    }

    static int euclidean(int a, int b) {
        if (b == 0) return a;

        return euclidean(b, a % b);
    }
}
