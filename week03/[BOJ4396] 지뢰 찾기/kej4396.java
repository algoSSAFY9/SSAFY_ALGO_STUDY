package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//84ms
public class kej4396 {
	// 윗줄 3개 양쪽 2개 아랫줄 3개
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][N];
		String[][] x_arr = new String[N][N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split(""); // 폭탄위치배열
		}

		for (int i = 0; i < N; i++) {
			x_arr[i] = br.readLine().split(""); // 체크하고싶은 위치 x배열
		}

		int result = 0;
		int nx, ny;
		int boam = 0; // 폭탄이 터졌는지 확인!
		String[][] res = new String[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result = 0;
				if (x_arr[i][j].equals("x")) { // x일때 폭탄확인
					if (arr[i][j].equals("*")) { // 폭탄을 열었을때 폭탄 전부 보여주기
						if (boam == 1)
							continue; // 이미 폭탄 터져서 위치 체크했으니까 넘어가기.
						for (int x = 0; x < N; x++) {
							for (int y = 0; y < N; y++) {
								if (arr[x][y].equals("*")) {
									res[x][y] = "*";
									boam = 1;
								}
							}
						}
					} else { // 폭탄이 아니라면 내 주위에 폭탄이 몇개 있는지 알아보고 res에 넣기
						for (int x = 0; x < 8; x++) {
							nx = i + dx[x];
							ny = j + dy[x];
							if (nx < 0 || nx >= N || ny < 0 || ny >= N)
								continue;
							else if (arr[nx][ny].equals("*"))
								result += 1;
						}
						res[i][j] = String.valueOf(result);
					}
				} else { // 그냥 .일때 현재 res에 아무것도 안들었으면 . 넣어주기
					if (res[i][j] == null) {
						res[i][j] = ".";
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
	}

}
