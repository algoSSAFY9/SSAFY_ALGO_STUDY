import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class kh16928 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int nm = 0; nm < N + M; nm++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            hm.put(a, b);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] visited = new int[106];
        q.add(1);
        Arrays.fill(visited, 2, 101, -1);
        while (visited[100] == -1) {
            int idx = q.poll();
            for (int i = 1; i <= 6; i++) {
                if (visited[idx + i] == -1) {
                    visited[idx + i] = visited[idx] + 1;
                    if (hm.containsKey(idx + i)) {
                        if (visited[hm.get(idx + i)] == -1) {
                            q.add(hm.get(idx + i));
                            visited[hm.get(idx + i)] = visited[idx + i];
                        }
                    } else {
                        q.add(idx + i);
                    }
                }
            }
        }
        bw.write(String.valueOf(visited[100]));
        bw.flush();
    }
}
