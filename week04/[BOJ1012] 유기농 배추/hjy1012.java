import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjy1012 {

	static int M, N, K;				// 가로, 세로, 배추 개수
	static int[][] cabbage;			// 배추 위치
	static boolean[][] isvisited;	// 확인 여부
	static int cnt;					// 지렁이 수
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String[] str = br.readLine().split(" ");
			M = Integer.parseInt(str[0]);	
			N = Integer.parseInt(str[1]);
			K = Integer.parseInt(str[2]);
			cabbage = new int[N][M];

			// 양배추 위치 저장
			for (int j = 0; j < K; j++) {
				str = br.readLine().split(" ");
				int c = Integer.parseInt(str[0]);
				int r = Integer.parseInt(str[1]);
				cabbage[r][c] = 1;
			}
			
			isvisited = new boolean[N][M];
			cnt = 0;

			// 연결여부 확인 
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					// 양배추 o 방문 x
					if (cabbage[r][c] == 1 && isvisited[r][c] == false) {
						dfs(r, c);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}

	}
	
	// 상하좌우 확인
	static void dfs(int r, int c) {
		isvisited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int c_r = r + dr[i];
			int c_c = c + dc[i];

			if (c_r >= 0 && c_c >= 0 && c_r < N && c_c < M) {
				if (cabbage[c_r][c_c] == 1 && isvisited[c_r][c_c] == false) {
					dfs(c_r, c_c);
				}
			}

		}

	}
}
