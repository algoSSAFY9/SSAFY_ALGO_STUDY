import java.io.*;
import java.util.StringTokenizer;

public class kh1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[] s = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) s[i] = Integer.parseInt(st.nextToken()) == 1;

        int M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            int idx = num - 1;
            if (gender == 1) {
                while (idx < N) {
                    s[idx] = !s[idx];
                    idx += num;
                }
            } else {
                s[idx] = !s[idx];
                for (int i = 1; 0 <= idx - i && idx + i < N && s[idx - i] == s[idx + i]; i++) {
                    s[idx - i] = !s[idx - i];
                    s[idx + i] = !s[idx + i];
                }
            }
        }

        int count = 1;
        for (boolean on : s) bw.write((on ? 1 : 0) + (count++ % 20 == 0 ? "\n" : " "));
        bw.flush();
    }
}
