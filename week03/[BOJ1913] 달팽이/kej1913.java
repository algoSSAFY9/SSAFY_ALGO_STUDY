package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class kej1913 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] numbers = new int[N][N];
		int x = N / 2;
		int y = N / 2;

		int turn = 1;
		int num = 2;
		numbers[x][y] = 1; // 시작점에 1 넣어주고 시작
		int idx_x = x+1;
		int idx_y = y+1;

		while (true) {
			for (int i = 0; i < turn; i++) {	// 위
				if (num == m) {
					idx_x = x;
					idx_y = y + 1;
				}
				numbers[--x][y] = num++;

			}
			for (int i = 0; i < turn; i++) {	// 오른쪽
				if (num == m) {
					idx_x = x + 1;
					idx_y = y + 2;
				}
				numbers[x][++y] = num++;
			}
			turn++;
			for (int i = 0; i < turn; i++) {	// 아래
				if (num == m) {
					idx_x = x + 2;
					idx_y = y + 1;
				}
				numbers[++x][y] = num++;
			}
			for (int i = 0; i < turn; i++) {	// 왼쪽
				if (num == m) {
					idx_x = x + 1;
					idx_y = y;
				}
				numbers[x][--y] = num++;
			}
			turn++;
			if (num - 1 == N * N - (N - 1))
				break;
		}

		for (int i = 0; i < N - 1; i++) {
			if (num == m) {
				idx_x = x;
				idx_y = y+1;
			}
			numbers[--x][y] = num++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(numbers[i][j]).append(" ");
			}
			if(i!=N-1) {
			sb.append("\n");}
		}
		System.out.println(sb + "\n" + idx_x + " " + idx_y);
	}

}
