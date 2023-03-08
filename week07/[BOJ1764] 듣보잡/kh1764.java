import java.io.*;
import java.util.*;

public class kh1764 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        
        HashSet<String> hs = new HashSet<>();
        for (int n = 0; n < N; n++) hs.add(br.readLine());

        TreeSet<String> 듣보잡 = new TreeSet<>();
        for (int m = 0; m < M; m++) {
            String name = br.readLine();
            if (hs.contains(name)) 듣보잡.add(name);
        }

        bw.write(String.valueOf(듣보잡.size()));
        bw.newLine();
        for (String name : 듣보잡) {
            bw.write(name);
            bw.newLine();
        }
        bw.flush();
    }
}
