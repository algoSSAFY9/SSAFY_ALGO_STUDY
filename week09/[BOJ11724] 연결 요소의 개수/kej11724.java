package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 연결요소의 개수
public class kej11724 {
	static int N, M;
	static ArrayList<Integer> list[];
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1];
		list = new ArrayList[N + 1];
		
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[x].add(y);
			list[y].add(x);
		}

		int cnt = 0;

		for (int i = 1; i < N + 1; i++) {
			if (!visit[i]) {
				dfs(i);
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static void dfs(int n) {
		if (visit[n])
			return;
		visit[n] = true;
		for (int i : list[n]) {
			if (!visit[i])
				dfs(i);
		}
	}

}
