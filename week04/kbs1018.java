import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kbs1018 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		int minV = Integer.MAX_VALUE;
		for (int startN = 0; startN < N - 7; startN++) { // 가로 line 시작 위치
			for (int startM = 0; startM < M - 7; startM++) { // 세로 line 시작 위치
				int cntB = 0; // 맨 왼쪽 맨 위가 B일 때, 색칠해야하는 개수
				int cntW = 0; // 맨 왼쪽 맨 위가 W일 때, 색칠해야하는 개수
				for (int x = startN; x < startN + 8; x++) {
					for (int y = startM; y < startM + 8; y++) {

						// if문으로 구분하면
						// W(if)B(else) | B(if)W(else)
						// B(else)W(if) | W(else)B(if)
						// if(맨 왼쪽 맨 위) -> W일때, if-> B일 때로 구분
						if ((x + y) % 2 == 0) {
							if (board[x][y] != 'B')
								cntB++;
							if (board[x][y] != 'W')
								cntW++;
						} else {
							if (board[x][y] != 'B')
								cntW++;
							if (board[x][y] != 'W')
								cntB++;
						}
					}
				}
				minV = Math.min(minV, Math.min(cntB, cntW));

			}
		}
		System.out.println(minV);
	}
}
