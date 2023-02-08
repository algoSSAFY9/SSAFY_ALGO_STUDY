import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kh22858 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] D = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x) - 1).toArray();
        int[] reverse_D = new int[N];
        for (int i = 0; i < N; i++) reverse_D[D[i]] = i;

        int[] P = S;
        for (int k = 0; k < K; k++) {
            int[] tmp = P;
            P = new int[N];
            for (int i = 0; i < N; i++) {
                P[i] = tmp[reverse_D[i]];
            }
        }

        for (int i : P) bw.write(i + " ");
        bw.flush();
    }
}
