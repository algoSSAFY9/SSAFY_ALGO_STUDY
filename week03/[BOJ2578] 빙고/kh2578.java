import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class kh2578 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                hm.put(Integer.parseInt(st.nextToken()), i * 5 + j);
            }
        }

        int[][] count = new int[4][];
        for (int i = 0; i < 2; i++) count[i] = new int[5];
        for (int i = 2; i < 4; i++) count[i] = new int[9];
        int line = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int rc = hm.get(Integer.parseInt(st.nextToken()));
                int r = rc / 5, c = rc % 5;
                int[] idx = {r, c, r + c, c - r + 4};
                for (int k = 0; k < 4; k++) {
                    if (++count[k][idx[k]] == 5) line++;
                }

                if (3 <= line) {
                    bw.write(String.valueOf(i * 5 + j + 1));
                    bw.flush();
                    System.exit(0);
                }
            }
        }
    }
}
