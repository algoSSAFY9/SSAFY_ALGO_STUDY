import java.io.*;
import java.util.StringTokenizer;

public class kh11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int S = 0, all = (1 << 20) - 1;
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x;
            switch (cmd) {
                case "add":
                    x = Integer.parseInt(st.nextToken()) - 1;
                    S |= 1 << x;
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken()) - 1;
                    S &= ~(1 << x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken()) - 1;
                    bw.write((S & 1 << x) == 0 ? "0" : "1");
                    bw.newLine();
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken()) - 1;
                    S ^= 1 << x;
                    break;
                case "all":
                    S = all;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        bw.flush();
    }
}
