import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class kh1260 {

    static TreeSet<Integer>[] ts;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        ts = new TreeSet[N + 1];
        for (int i = 1; i <= N; i++) ts[i] = new TreeSet<>();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            ts[u].add(v);
            ts[v].add(u);
        }

        visited = new boolean[N + 1];
        dfs(V);

        sb.append("\n");

        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited = new boolean[N + 1];
        q.offer(V);
        visited[V] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append(u).append(" ");
            for (Integer v : ts[u]) {
                if (!visited[v]) {
                    q.offer(v);
                    visited[v] = true;
                }
            }
        }

        System.out.println(sb);
    }

    static void dfs(int u) {
        visited[u] = true;
        sb.append(u).append(" ");
        for (Integer v : ts[u]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
}
