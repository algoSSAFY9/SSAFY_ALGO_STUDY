import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

// 단지번호 붙이기 

public class kej2667 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
				if(map[i][j] == 0) visit[i][j] = true;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
					count++;
					res.add(sum);
				}
			}
		}
		Collections.sort(res);
		System.out.println(count);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

	static ArrayList<Integer> res = new ArrayList<>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int sum = 0;

	static void bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });
		visit[x][y] = true;
		map[x][y] = 0;
		sum = 1;
		while (!q.isEmpty()) {
			int[] idx = q.pollFirst();
			for (int i = 0; i < 4; i++) {
				int nx = idx[0] + dx[i];
				int ny = idx[1] + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] == true) {
					continue;
				} else {
					map[nx][ny] = 0;
					visit[nx][ny] = true;
					q.add(new int[] { nx, ny });
					sum++;
				}

			}
		}
	}

}
