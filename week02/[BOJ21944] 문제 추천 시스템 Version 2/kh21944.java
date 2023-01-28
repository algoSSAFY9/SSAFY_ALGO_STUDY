import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class kh21944 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer>[] problems = new TreeMap[101];
        TreeMap<Integer, Integer>[] levels = new TreeMap[101];
        TreeMap<Integer, Integer> algo = new TreeMap<>();
        for (int i = 0; i < 101; i++) {
            problems[i] = new TreeMap<>();
            levels[i] = new TreeMap<>();
        }
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken()) * 1000000;
            int G = Integer.parseInt(st.nextToken());
            problems[0].put(P, L + P);
            problems[G].put(P, L + P);
            levels[0].put(L + P, P);
            levels[G].put(L + P, P);
            algo.put(P, G);
        }
        int M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("recommend")) {
                int G = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int P = (x == 1 ? levels[G].lastKey() : levels[G].firstKey()) % 1000000;
                bw.write(P + "\n");
            } else if (command.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                int P = (x == 1 ? levels[0].lastKey() : levels[0].firstKey()) % 1000000;
                bw.write(P + "\n");
            } else if (command.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken()) * 1000000;
                Integer P = (x == 1 ? levels[0].ceilingKey(L) : levels[0].floorKey(L));
                P = P == null ? -1 : P % 1000000;
                bw.write(P + "\n");
            } else if (command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken()) * 1000000;
                int G = Integer.parseInt(st.nextToken());
                problems[0].put(P, L + P);
                levels[0].put(L + P, P);
                problems[G].put(P, L + P);
                levels[G].put(L + P, P);
                algo.put(P, G);
            } else {
                int P = Integer.parseInt(st.nextToken());
                int G = algo.remove(P);
                levels[0].remove(problems[0].get(P));
                problems[0].remove(P);
                levels[G].remove(problems[G].get(P));
                problems[G].remove(P);
            }
        }

        bw.flush();
    }
}
