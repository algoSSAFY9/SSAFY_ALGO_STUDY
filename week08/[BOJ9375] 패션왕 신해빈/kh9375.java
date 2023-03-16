import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class kh9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String 이름 = st.nextToken();
                String 종류 = st.nextToken();
                hm.put(종류, hm.getOrDefault(종류, 0) + 1);
            }


            int ans = 1;
            for (Integer value : hm.values()) ans *= value + 1;
            bw.write(String.valueOf(ans - 1));
            bw.newLine();
        }
        bw.flush();
    }
}
