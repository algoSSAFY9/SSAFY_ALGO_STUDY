import java.io.*;
import java.util.*;

public class kh1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        HashMap<String, String> hm = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String num = String.valueOf(i);
            String name = br.readLine();
            hm.put(num, name);
            hm.put(name, num);
        }

        for (int i = 0; i < M; i++) {
            bw.write(hm.get(br.readLine()));
            bw.newLine();
        }

        bw.flush();
    }
}
