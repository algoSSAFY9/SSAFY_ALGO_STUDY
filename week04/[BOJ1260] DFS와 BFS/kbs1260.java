import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map;
	static boolean[] visits;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][N + 1];
		visits = new boolean[N + 1];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			map[b][a] = true;
		}
		visits[V] = true;
		sb.append(V + " ");
		dfs(V);
		sb.append("\n");

		visits = new boolean[N + 1]; // bfs를 위해 초기화
		bfs(V);
		System.out.println(sb);
	}

	// dfs
	static void dfs(int cur) {
		for (int i = 1; i < map[cur].length; i++) {
			if (map[cur][i] && !visits[i]) {
				visits[i] = true;
				sb.append(i + " ");
				dfs(i);
			} else
				continue;
		}

	}

	// bfs
	static void bfs(int cur) {

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(cur);
		while (!q.isEmpty()) {
			int curIdx = q.poll();
			visits[curIdx] = true;
			sb.append(curIdx + " ");

			for (int i = 1; i < map[curIdx].length; i++) {
				if (map[curIdx][i] && !visits[i]) {
					visits[i] = true;
					q.offer(i);
				}
			}

		}
	}
}
