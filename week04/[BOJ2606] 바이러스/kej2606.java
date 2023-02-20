package Bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kej2606 {
	static int N, M;
	static ArrayList<Integer>[] list;
	static int[] visited;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		visited = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		BFS(1);
		System.out.println(cnt-1);
	}

	static void BFS(int idx) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(idx);
		visited[idx] = 1;
		cnt++;

		while (qu.size() != 0) {
			idx = qu.poll();
			if (visited[idx] != 1) {
				visited[idx] = 1;
				cnt++;
			}
			for (int i = 0; i < list[idx].size(); i++) {
				if (visited[list[idx].get(i)] != 1) {
					qu.add(list[idx].get(i));
				}
			}
		}

	}

}
