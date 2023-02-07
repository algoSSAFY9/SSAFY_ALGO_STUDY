import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw4396 {
	static char[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new char[n][n];
		
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		String[][] res = new String[n][n];
		boolean chk = false;
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				char now = line.charAt(j);
				if(now == '.') {
					res[i][j] = ".";
					continue;
				}
				
				if(arr[i][j] == '*') chk = true;
				else {
					res[i][j] = Integer.toString(bomb(i, j, n));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == '*' && chk) sb.append("*");
				else sb.append(res[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	static int bomb(int x, int y, int n) {
		int cnt = 0;
		
		for(int i=0; i<8; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == '*') cnt++;
		}
		
		return cnt;
	}
}
