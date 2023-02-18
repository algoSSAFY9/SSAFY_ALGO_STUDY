import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hjw2178 {
	static int n, m;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		cal();
	}
	
	static void cal() {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		boolean[][] chk = new boolean[n][m];
		chk[0][0] = true;
		Queue<int[] > q = new LinkedList<>();
		q.add(new int[] {0, 0, 1});
		
		while(!q.isEmpty()) {
			int[] pol = q.poll();
			int x = pol[0];
			int y = pol[1];
			int cnt = pol[2];
			
			for(int i=0; i<4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if(!chk[nx][ny] && arr[nx][ny] == 1) {
					if(nx == n-1 && ny == m-1) { // 끝점
						System.out.println(cnt + 1);
						return;
					}
					chk[nx][ny] = true;
					q.add(new int[] {nx, ny, cnt+1});
				}
			}
			
		}
	}
}
