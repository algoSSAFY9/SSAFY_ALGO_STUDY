import java.io.*;
import java.util.*;

public class kh2606 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] arr = new ArrayList[N];
		for (int i = 0; i < N; i++) arr[i] = new ArrayList<>();

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			arr[a].add(b);
			arr[b].add(a);
		}

		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[N];
		stack.push(0);
		visited[0] = true;
		int ans = -1;
		while (!stack.isEmpty()) {
			ans++;
			int com = stack.pop();
			for (int i : arr[com]) {
				if (!visited[i]) {
					stack.push(i);
					visited[i] = true;
				}
			}
		}
		bw.write(String.valueOf(ans));

		bw.flush();
	}
}
