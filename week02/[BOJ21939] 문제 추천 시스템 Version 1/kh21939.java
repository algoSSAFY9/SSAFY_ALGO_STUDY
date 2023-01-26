import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class kh21939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> problems = new TreeMap<>();
        TreeMap<Integer, Integer> levels = new TreeMap<>();
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
            problems.put(P, L * 1000000 + P);
            levels.put(L * 1000000 + P, P);
        }
        int M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                int P = (x == 1 ? levels.lastKey() : levels.firstKey()) % 1000000;
                bw.write(P + "\n");
            } else if (command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                if (problems.containsKey(P)) {
                    levels.remove(problems.get(P));
                }
                problems.put(P, L * 1000000 + P);
                levels.put(L * 1000000 + P, P);
            } else {
                int P = Integer.parseInt(st.nextToken());
                levels.remove(problems.get(P));
                problems.remove(P);
            }
        }

        bw.flush();
    }
}
