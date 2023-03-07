import java.io.*;
import java.util.StringTokenizer;

public class kh11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = N - 1; K > 0; i--) {
            ans += K / A[i];
            K %= A[i];
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
