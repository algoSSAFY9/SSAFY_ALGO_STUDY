package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 케빈 베이컨의 6단계 법칙
public class kej1389 {
	static int N, M;
	static LinkedList<Integer>[] list;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new LinkedList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[x].add(y);
			list[y].add(x);
		}

		for (int i = 1; i <= N; i++) {
			visit = new boolean[N + 1];
			BFS(i);
		}
		System.out.println(minP);

	}
	static int minP = Integer.MAX_VALUE;
	static int minV = Integer.MAX_VALUE;
	static void BFS(int x) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, 0 }); // 시작점, 방문횟수 ( 초기 0 )
		visit[x] = true;
		int v = 1;
		int result = 1;
		while (!q.isEmpty()) {
			int[] n = q.pollFirst();
			int idx = n[0];
			int cnt = n[1];
			result += cnt;
			for (int i = 0; i < list[idx].size(); i++) {
				if (visit[list[idx].get(i)])
					continue;
				visit[list[idx].get(i)] = true;
				q.add(new int[] { list[idx].get(i), cnt + 1 });
				v += 1;
			}
		}
		if(v == N) {	// 방문횟수가 유저의 수랑 같아지면
			// 베이컨의 최소값이 같은가?
			if(result == minV) {
				// 그렇다면 번호가 가장 작은 사람
				minP = Math.min(x, minP);
			} else if(result < minV) {
				minP = x;
				minV = result;
			}
		}
	}

}
