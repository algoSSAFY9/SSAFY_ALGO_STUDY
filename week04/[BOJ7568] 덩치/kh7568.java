import java.io.*;
import java.util.StringTokenizer;

public class kh7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];
        int[] y = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N; j++) {
                if (x[i] < x[j] && y[i] < y[j]) {
                    count++;
                }
            }
            bw.write(count + " ");
        }
        bw.flush();
    }
}
