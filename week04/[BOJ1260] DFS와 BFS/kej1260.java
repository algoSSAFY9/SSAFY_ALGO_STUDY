package Bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kej1260 {
	static int N, M, V;
	static int[] visited;
	static ArrayList<Integer>[] list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visited = new int[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		for(int i = 1; i<list.length;i++) {	// 정렬
			Collections.sort(list[i]);
		}
		
		DFS(V);
		System.out.println(sb);
		sb = new StringBuilder();
		visited = new int[N + 1];
		BFS(V);
		System.out.println(sb);
	}

	static void DFS(int idx) {
		visited[idx] = 1;
		sb.append(idx).append(" ");
		for (int i = idx; i < list.length; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				if (visited[list[i].get(j)] != 1) {
					DFS(list[i].get(j));
				}
			}
			return;
		}
	}

	static void BFS(int idx) {
		visited[idx] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		sb.append(idx+" ");

		while (q.size() != 0) {
			int x = q.poll();
			if(visited[x] != 1) {
				visited[x] = 1;
				sb.append(x).append(" ");
			}
			for (int i = 0; i < list[x].size(); i++) {
				if (visited[list[x].get(i)] != 1) {
					q.add(list[x].get(i));
				}
			}
		}

	}
}
