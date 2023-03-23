import java.io.*;
import java.util.*;

public class kh11724 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] arr = new ArrayList[N];
        for (int i = 0; i < N; i++) arr[i] = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1, v = Integer.parseInt(st.nextToken()) - 1;
            arr[u].add(v);
            arr[v].add(u);
        }

        boolean[] visited = new boolean[N];
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                ans++;
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited[i] = true;
                while (!stack.isEmpty()) {
                    int u = stack.pop();
                    for (Integer v : arr[u]) {
                        if (!visited[v]) {
                            stack.push(v);
                            visited[v] = true;
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
