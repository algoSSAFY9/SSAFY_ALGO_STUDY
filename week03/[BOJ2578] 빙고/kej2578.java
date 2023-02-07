package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 124ms

public class kej2578 {
	static int[][] arr = new int[5][5];
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int n;
		int result = 0;
		int stop_flag = 0;
		int left_cross = 0;
		int right_cross = 0;
		for (int tc = 0; tc < 5; tc++) {
			st = new StringTokenizer(br.readLine());
			for (int t = 0; t < 5; t++) {
				n = Integer.parseInt(st.nextToken());
				result += 1;
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (arr[i][j] == n) {
							arr[i][j] = 0;
							row_check(i);
							column_check(j);
							// 대각선은 만들어졌다는 걸 한번 확인하면 더이상 확인 x
							// left_cross, right_cross는 그거 체크용
							if (left_cross == 0) left_cross = Lcross_check(i, j);
							if(right_cross == 0) right_cross = Rcross_check(i, j);
							// 빙고 3개 되면 stop,,,
							if (cnt >= 3) {
								System.out.println(result);
								stop_flag = 1;
							}
							break;
						}
					} // for문 멈춰,,
					if (stop_flag == 1) {
						break;
					}
				}	// 그만둬,,,,
				if (stop_flag == 1) {
					break;
				}
			}	// 악!
			if (stop_flag == 1) {
				break;
			}
		}
	}

	// 가로 체크
	public static void row_check(int i) {
		int zero = 0;
		for (int x = 0; x < 5; x++) {
			if (arr[i][x] == 0) {
				zero++;
			} else
				break;
		}
		if (zero == 5)
			cnt++;
	}

	// 세로 체크
	public static void column_check(int j) {
		int zero = 0;
		for (int x = 0; x < 5; x++) {
			if (arr[x][j] == 0) {
				zero++;
			} else
				break;
		}
		if (zero == 5)
			cnt++;
	}

	// 대각선 체크 왼쪾
	public static int Lcross_check(int i, int j) {
		int zero = 0;
		if (i == j) { // i,j가 같으면 왼쪽 대각선
			for (int x = 0; x < 5; x++) {
				if (arr[x][x] == 0) {
					zero++;
				} else
					break;
			}
			if (zero == 5) {
				cnt++;
				return 1;
			}
		}
		return 0;
	}
	// 오른쪽 대각
	public static int Rcross_check(int i, int j) {
		int zero = 0;
		for (int x = 0; x < 5; x++) {
			if (arr[x][4 - x] == 0) {
				zero++;
			} else
				break;
		}
		if (zero == 5) {
			cnt++;
			return 1;
		}
		return 0;
	}

}