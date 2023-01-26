import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class kh7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> Q = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                char oper = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());
                if (oper == 'I') {
                    Q.put(n, Q.getOrDefault(n, 0) + 1);
                } else {
                    if (!Q.isEmpty()) {
                        int key = n == 1 ? Q.lastKey() : Q.firstKey();
                        int value = Q.get(key);
                        value--;
                        if (value == 0) {
                            Q.remove(key);
                        } else {
                            Q.put(key, value);
                        }
                    }
                }
            }
            bw.write(Q.isEmpty() ? "EMPTY" : Q.lastKey() + " " + Q.firstKey());
            bw.newLine();
        }

        bw.flush();
    }
}
