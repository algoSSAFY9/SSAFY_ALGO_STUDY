import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kh11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(P);

        int sum = 0;
        for (int i = 0; i < N; i++) sum += P[i] * (N - i);
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
