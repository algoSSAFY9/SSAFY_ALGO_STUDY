import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjy1018 {

	public static boolean[][] map;
	public static int min = 64;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
 
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
 
		map = new boolean[N][M];
		
 
		// 배열 입력 
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < M; j++) {
				if (line.charAt(j) == 'W') {
					map[i][j] = true;		// W일 때는 true 
				} else {
					map[i][j] = false;		// B일 때는 false
				}
 
			}
		}
 
		// 8*8 크기로 검사
		int N_row = N - 7;
		int M_col = M - 7;
 
		for (int i = 0; i < N_row; i++) {
			for (int j = 0; j < M_col; j++) {
				find(i, j);
			}
		}
		System.out.println(min);
	}
 
	
	public static void find(int x, int y) {
		// 8*8 크기로 검사
		int end_x = x + 8;
		int end_y = y + 8;
		int cnt = 0;
 
		boolean wb = map[x][y];	// 첫 번째 칸의 색 
 
		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {
 
				// 올바른 색이 아닐경우 count 1 증가 
				if (map[i][j] != wb) {	
					cnt++;
				}
				wb = (!wb);		// 색 전환 : true
			}			
			wb = !wb;	// 색 전환 : false
		}
		
		// 첫 칸 색 기준 바꿀 개수 : cnt
		// 반대색 기준 바꿀 개수 : 64-cnt
		if(cnt > 32) 
			cnt = 64 - cnt;
		// 이전 최솟값이랑 비교
		min = Math.min(min, cnt);
	}
}
