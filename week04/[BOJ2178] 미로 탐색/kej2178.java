package Bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class idx_1 {
	int x;
	int y;
	int cnt;

	idx_1(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class kej2178 {
	static int N, M;
	static int[][] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[N][M];
		String s;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < M; j++) {
				list[i][j] = s.charAt(j) - '0';
			}
		}
		check(0, 0);
		System.out.println(list[N - 1][M - 1]);
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void check(int a, int b) {
		int idx_x = a;
		int idx_y = b;
		int cnt = 1;
		Queue<idx_1> q = new LinkedList<>();
		q.add(new idx_1(a, b, cnt));
		list[a][b] = cnt;
		while (!q.isEmpty()) {
			if (idx_x == N - 1 && idx_y == M - 1)
				break;
			idx_1 arr = q.poll();
			for (int i = 0; i < 4; i++) {
				idx_x = arr.x + dx[i];
				idx_y = arr.y + b + dy[i];
				cnt = arr.cnt;
				if (idx_x < 0 || idx_x >= N || idx_y < 0 || idx_y >= M)
					continue;
				if (list[idx_x][idx_y] == 1) {
					q.add(new idx_1(idx_x, idx_y, cnt + 1));
					list[idx_x][idx_y] = cnt + 1;
				}
			}
		}
	}
}
