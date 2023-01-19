import java.io.*;
import java.util.*;

public class kh14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hs.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (hs.contains(br.readLine())) {
                count++;
            }
        }
        bw.write(String.valueOf(count));

        bw.flush();
    }
}
