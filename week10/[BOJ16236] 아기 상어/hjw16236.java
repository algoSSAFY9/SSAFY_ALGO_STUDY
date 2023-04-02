import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hjw16236 {
	static int[][] map;
	static int sX, sY, N;
	static final int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sX = i;
					sY = j;
				} else if (map[i][j] != 0)
					cnt++;
			}
		}

		int res = 0, size = 2, sizeChk = 0;
		while (cnt > 0) {
			int mid = cal(size);
			if (mid == INF) break;

			res += mid;
			sizeChk++;
			if (sizeChk == size) {
				sizeChk = 0;
				size++;
			}
			cnt--;
		}

		System.out.println(res);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int cal(int size) {
		boolean[][] chk = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sX, sY, 0 });
		map[sX][sY] = 0;
		chk[sX][sY] = true;

		int row = N, col = N, cnt = INF;
		while (!q.isEmpty()) {
			int[] pol = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + pol[0];
				int ny = dy[i] + pol[1];

				// 자신보다 큰 물고기가 있는 칸 지나갈 수 없다.
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] || map[nx][ny] > size) continue; 
				chk[nx][ny] = true;

				if (map[nx][ny] != 0 && map[nx][ny] < size) {
					if (cnt > pol[2] + 1) {
						row = nx;
						col = ny;
						cnt = pol[2] + 1;
					}
					if (cnt == pol[2] + 1) {
						if (nx < row) {
							row = nx;
							col = ny;
						} else if (nx == row && ny < col) {
							row = nx;
							col = ny;
						}
					}
				}

				q.add(new int[] { nx, ny, pol[2] + 1 });
			}
		}
		sX = row;
		sY = col;

		return cnt;
	}
}
