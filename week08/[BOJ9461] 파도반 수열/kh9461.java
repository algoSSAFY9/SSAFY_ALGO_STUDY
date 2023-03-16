import java.io.*;

public class kh9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] P = new long[101];
        P[1] = P[2] = P[3] = 1;
        for (int i = 4; i < 101; i++) P[i] = P[i - 2] + P[i - 3];


        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(P[N]));
            bw.newLine();
        }
        bw.flush();
    }
}
