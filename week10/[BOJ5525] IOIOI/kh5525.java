import java.io.*;

public class kh5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        int ans = 0, count = 0;
        char pre = '.';
        for (int i = 0; i < M; i++) {
            if (pre == S[i]) count = 0;

            if (S[i] == 'I' && N < ++count) ans++;
            
            pre = S[i];
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
