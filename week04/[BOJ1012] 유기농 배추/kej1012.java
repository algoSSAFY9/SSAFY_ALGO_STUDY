package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kej1012 {
	static int T, M, N, K;
	static int[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		int x, y;
		int result = 0;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());	// 가로길이
			N = Integer.parseInt(st.nextToken());	// 세로길이
			K = Integer.parseInt(st.nextToken());	// 배추위치 개수
			visited = new int[N][M];
			result = 0;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				visited[y][x] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] == 1) {
						visited[i][j] = 0;
						check(i, j);
						result += 1;
					}
				}
			}
			System.out.println(result);
		}
	}

	// 왼쪽, 위쪽, 오른쪽, 아래쪽
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static void check(int a, int b) {
		int idx_x = a;
		int idx_y = b;

		for (int k = 0; k < 4; k++) {
			idx_x = a + dx[k];
			idx_y = b + dy[k];

			while (idx_x >= 0 && idx_x < N && idx_y >= 0 && idx_y < M) {
				if (visited[idx_x][idx_y] == 1) {
					visited[idx_x][idx_y] = 0;
					check(idx_x, idx_y);
				} else
					break;
			}

		}
		return;
	}

}
